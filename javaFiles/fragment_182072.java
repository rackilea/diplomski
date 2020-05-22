public static Stream<MatchResult> findAll(Scanner s, Pattern pattern) {
    return StreamSupport.stream(new Spliterators.AbstractSpliterator<MatchResult>(
            1000, Spliterator.ORDERED|Spliterator.NONNULL) {
        public boolean tryAdvance(Consumer<? super MatchResult> action) {
            if(s.findWithinHorizon(pattern, 0)!=null) {
                action.accept(s.match());
                return true;
            }
            else return false;
        }
    }, false);
}
public static Stream<MatchResult> results(Matcher m) {
    return StreamSupport.stream(new Spliterators.AbstractSpliterator<MatchResult>(
            m.regionEnd()-m.regionStart(), Spliterator.ORDERED|Spliterator.NONNULL) {
        public boolean tryAdvance(Consumer<? super MatchResult> action) {
            if(m.find()) {
                action.accept(m.toMatchResult());
                return true;
            }
            else return false;
        }
    }, false);
}