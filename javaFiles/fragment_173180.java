public static Ab asAb(final TypeA obj) {
    return new Ab() {
        public void someOp() {
            obj.someOp();
        }
    };
}