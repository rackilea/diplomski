default Op combinedOp(Op secondOperation) {
    return new Op() {
        @Override
        public void runOp() {
            secondOperation.runOp();
        }
    };
}