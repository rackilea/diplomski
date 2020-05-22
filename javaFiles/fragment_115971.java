private <V> V calculateResult(Event event,
                              Class<V> valueType,
                              BinaryOperator<V> operation) {

    return calculateResult(event, valueType, valueType, operation);
}