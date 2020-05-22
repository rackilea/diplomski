static TerminalOp<Integer, Integer> makeInt(int identity, IntBinaryOperator operator) {
    class ReducingSink implements ... {
        private int state;

        //...

        @Override
        public void accept(int t) {
            state = operator.applyAsInt(state, t); // <----------
        }

        //...
    }
    return new ReduceOp<Integer, Integer, ReducingSink>(StreamShape.INT_VALUE) {
        @Override
        public ReducingSink makeSink() {
            return new ReducingSink();
        }
    };
}