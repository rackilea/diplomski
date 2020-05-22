private <V> V calculateDelta(Event event,
                             Class<V> valueType,
                             BinaryOperator<V> operation) {

    V firstValue = valueType.cast(
        event.getAttributeValue(
            StockEventTypesManager.firstStockMeasurementIndex));

    V secondValue = valueType.cast(
        event.getAttributeValue(
            StockEventTypesManager.firstStockMeasurementIndex + 1));

    return operation.apply(firstValue, secondValue);
}