private <V, U, R> R calculateResult(Event event,
                                    Class<V> firstValueType,
                                    Class<U> secondValueType,
                                    BiFunction<V, U, R> operation) {

    V firstValue = firstValueType.cast(
        event.getAttributeValue(
            StockEventTypesManager.firstStockMeasurementIndex));

    U secondValue = secondValueType.cast(
        event.getAttributeValue(
            StockEventTypesManager.firstStockMeasurementIndex + 1));

    return operation.apply(firstValue, secondValue);
}