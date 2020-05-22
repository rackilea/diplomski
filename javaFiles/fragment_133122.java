[...]
TextExtractor textExtractor = new TextExtractor(true, true);
for (final Page page : file.getDocument().getPages()) {
    Map<Rectangle2D, List<ITextString>> textStrings = textExtractor.extract(page);

    List<Match> matches = new ArrayList<>();

    for (Keyword e : l) {
        final String searchKey = e.getKey();
        final String translationKeyword = e.getValue();

        final Pattern pattern;
        if ((searchKey.contains(")") && searchKey.contains("("))
                || (searchKey.contains("(") && !searchKey.contains(")"))
                || (searchKey.contains(")") && !searchKey.contains("(")) || searchKey.contains("?")
                || searchKey.contains("*") || searchKey.contains("+")) {
            pattern = Pattern.compile(Pattern.quote(searchKey), Pattern.CASE_INSENSITIVE);
        } else
            pattern = Pattern.compile("\\b" + searchKey + "\\b", Pattern.CASE_INSENSITIVE);

        final Matcher matcher = pattern.matcher(TextExtractor.toString(textStrings).toLowerCase());

        textExtractor.filter(textStrings, new TextExtractor.IIntervalFilter() {
            public boolean hasNext() {
                return matcher.find();
            }

            public Interval<Integer> next() {
                return new Interval<Integer>(matcher.start(), matcher.end(), true, false);
            }

            public void process(Interval<Integer> interval, ITextString match) {
                matches.add(new Match(interval, match, translationKeyword));
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        });
    }

    removeOverlaps(matches);

    for (Match match : matches) {
        List<Quad> highlightQuads = new ArrayList<Quad>();
        {
            Rectangle2D textBox = null;
            for (TextChar textChar : match.match.getTextChars()) {
                Rectangle2D textCharBox = textChar.getBox();
                if (textBox == null) {
                    textBox = (Rectangle2D) textCharBox.clone();
                } else {
                    if (textCharBox.getY() > textBox.getMaxY()) {
                        highlightQuads.add(Quad.get(textBox));
                        textBox = (Rectangle2D) textCharBox.clone();
                    } else {
                        textBox.add(textCharBox);
                    }
                }

                textBox.setRect(textBox.getX(), textBox.getY(), textBox.getWidth(),
                        textBox.getHeight());
                highlightQuads.add(Quad.get(textBox));
            }

            new TextMarkup(page, highlightQuads, match.tag, MarkupTypeEnum.Highlight);
        }
    }
}
[...]