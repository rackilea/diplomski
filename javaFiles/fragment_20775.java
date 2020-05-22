public interface TwoArgIntOperator {
    public int op(int a, int b);
}

//elsewhere:
static int method(TwoArgIntOperator operator) {
    return operator.op(5, 10);
}