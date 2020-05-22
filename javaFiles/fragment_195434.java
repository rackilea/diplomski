public final class PatternStreamer {
    private final Pattern pattern;
    public PatternStreamer(String regex) {
        this.pattern = Pattern.compile(regex);
    }
    public Stream<MatchResult> results(CharSequence input) {
        List<MatchResult> list = new ArrayList<>();
        for (Matcher m = this.pattern.matcher(input); m.find(); )
            list.add(m.toMatchResult());
        return list.stream();
    }
}