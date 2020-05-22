class Match {
    final Interval<Integer> interval;
    final ITextString match;
    final String tag;

    public Match(final Interval<Integer> interval, final ITextString match, final String tag) {
        this.interval = interval;
        this.match = match;
        this.tag = tag;
    }
}