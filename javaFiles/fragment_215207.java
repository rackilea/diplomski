static private class BinaryOp extends JExpressionImpl {

    String op;
    JExpression left;
    JGenerable right;

    BinaryOp(String op, JExpression left, JGenerable right) {
        this.left = left;
        this.op = op;
        this.right = right;
    }

    public void generate(JFormatter f) {
        f.p('(').g(left).p(op).g(right).p(')');
    }

}