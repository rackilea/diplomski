// BiFunction<Operator, Operands, Result>
// Operator = BinaryOperator<?>
// Operands = Pair<?, ?>
BiFunction<BinaryOperator<Integer>, Pair<Integer, Integer>, Integer> f = 
    (operator, operands) -> 
        operator.apply(operands.getKey(), operands.getValue());

f.apply((a, b) -> a + b, new Pair<>(2, 2)); // 4