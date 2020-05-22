private Object visitBinaryOperatorNode(BinaryOpNode node, BiFunction<T, T> op) {
    Object lhs = node.getLeftHandSide().accept(this);
    Object rhs = node.getRightHandSide().accept(this);

    if (lhs instanceof Long && rhs instanceof Long) {
        return op.apply((long) lhs, (long) rhs);
    }
    throw new TypeError("Can not take " + node.getOpName() + "of " + lhs.getClass() + " and " + rhs.getClass() + ".");
}