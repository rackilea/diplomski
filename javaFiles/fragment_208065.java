class Operator implements ExpressionNode {
    public ExpressionNode simplify() {
    if (getAllVariables().isEmpty()) {
        return new Constant(getValue());
    } else {
        Operator simplified = new Operator(operation);
        for (ExpressionNode operand: operands) {
            simplified.addOperand(operand.simplify());
        }
        return simplified;
    }
}