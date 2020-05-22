public static <T> TerminalOp<T, Boolean> makeRef(Predicate<? super T> predicate,
        MatchKind matchKind) {
    Objects.requireNonNull(predicate);
    Objects.requireNonNull(matchKind);
    class MatchSink extends BooleanTerminalSink<T> {
        MatchSink() {
            super(matchKind);
        }

        @Override
        public void accept(T t) {
            if (!stop && predicate.test(t) == matchKind.stopOnPredicateMatches) {
                stop = true;
                value = matchKind.shortCircuitResult;
            }
        }
    }

    return new MatchOp<>(StreamShape.REFERENCE, matchKind, MatchSink::new);
}