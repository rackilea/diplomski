Integer first = 10;
Integer second = 60;
IntBinaryOperator intBinaryOperator = new IntBinaryOperator() {
    @Override
    public int applyAsInt(int a, int b) {
        return Integer.sum(a, b);
    }
};
Integer result = intBinaryOperator.applyAsInt(first, second);