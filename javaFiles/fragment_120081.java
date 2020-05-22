Pattern tagFinder = Pattern.compile("/JJ");
    BufferedReader reader = getMyReader();
    String line = null;
    while ((line = reader.readLine()) != null) {
        BreakIterator bi = BreakIterator.getSentenceInstance();
        bi.setText(line);
        int end, start = bi.first();
        while ((end = bi.next()) != BreakIterator.DONE) {
            String sentence = line.substring(start, end);
            String tagged = tagger.tagString(sentence);
            int score = 0;
            Matcher tag = tagFinder.matcher(tagged);
            while (tag.find())
                score++;
            if (score > 1)
                writerForTempFile.println(sentence);
            start = end;
        }
    }