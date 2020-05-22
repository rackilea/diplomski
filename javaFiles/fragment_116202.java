public static void main(String[] args) {
    Expression left1 = new BasicExpression(ScriptObject.of(42));
    Expression right1 = new BasicExpression(ScriptObject.of(3));     
    Expression sum = createSumExpression(left1, right1);
    System.out.printf("%s + %s = %s%n",left1.getValue(), right1.getValue(), sum.getValue());

    Expression left2 = new BasicExpression(ScriptObject.of(true));
    Expression right2 = new BasicExpression(ScriptObject.of(false));
    Expression and = createAndExpression(left2, right2);
    System.out.printf("%s && %s = %s%n",left2.getValue(), right2.getValue(), and.getValue());

    createAndExpression(left1, right2).getValue(); // fails with: Can not apply '&' to '42' and 'false' 
}

private static Expression createSumExpression(Expression left, Expression right) {
    return new BinaryExpression(left, right) {
        @Override
        protected ScriptObject operation(ScriptObject left, ScriptObject right) {
            if(!ScriptObject.areType(Type.Integer, left, right)) {
                throw new RuntimeException("Can not apply '+' to '" + left + "' and '" + right + "'");
            }
            return ScriptObject.of(left.asInt() + right.asInt());
        }
    };
}

private static Expression createAndExpression(Expression left, Expression right) {
    return new BinaryExpression(left, right) {
        @Override
        protected ScriptObject operation(ScriptObject left, ScriptObject right) {
            if(!ScriptObject.areType(Type.Boolean, left, right)) {
                throw new RuntimeException("Can not apply '&' to '" + left + "' and '" + right + "'");
            }
            return ScriptObject.of(left.asBoolean() && right.asBoolean());
        }
    };
}