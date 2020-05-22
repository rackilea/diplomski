private BooleanJunction addInCriticalStock(QueryBuilder queryBuilder, BooleanJunction booleanJunction, boolean inCriticalStock) {
    return booleanJunction
            .must(queryBuilder
                    .range()
                    .onField("minimumStockDifference")
                    .above(0)
                    .createQuery()
            );
}