private static final List<BinaryOperator<?, ?>> VALID_ADD_OPERATORS = Arrays.asList(
    new BinaryOperator<>((x, y) -> x + y, Double.class), 
    new BinaryOperator<>((x, y) -> x + y, Long.class),
    new BinaryOperator<>((x, y) -> x + y, String.class)
);

private static final List<BinaryOperator<?, ?>> VALID_MULTIPLY_OPERATORS = Arrays.asList(
    new BinaryOperator<>((x, y) -> x * y, Double.class), 
    new BinaryOperator<>((x, y) -> x * y, Long.class)
);

@Override
public Object visitAddNode(AddNode addNode) {
    return visitBinaryOperatorNode(addNode, VALID_ADD_OPERATORS );
}

@Override
public Object visitMultiplyNode(MultiplyNode multiplyNode) { 
    return visitBinaryOperatorNode(multiplyNode, VALID_MULTIPLY_OPERATORS ); 
}

private Object visitBinaryOperatorNode(BinaryOpNode node, List<BinaryOperator<?, ?>> validOperators) {
    Object lhs = node.getLeftHandSide().accept(this);
    Object rhs = node.getRightHandSide().accept(this);

    for (BinaryOperator<?, ?> op : validOperators) {
        if (op.isApplicable(lhs, rhs)) return op.apply(lhs, rhs);
    }
    throw new TypeError("Can not take " + node.getOpName() + "of " + lhs.getClass() + " and " + rhs.getClass() + ".");
}