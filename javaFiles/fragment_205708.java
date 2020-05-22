private static Stream<MatchResult> matches(Scanner s, String pattern) {
    Pattern compiled=Pattern.compile(pattern);
    return StreamSupport.stream(
        new Spliterators.AbstractSpliterator<MatchResult>(1000,
                         Spliterator.ORDERED|Spliterator.NONNULL) {
        @Override
        public boolean tryAdvance(Consumer<? super MatchResult> action) {
            if(s.findWithinHorizon(compiled, 0)==null) return false;
            action.accept(s.match());
            return true;
        }
    }, false);
}