return referenceService.getReferenceTable(referenceKey)
    .switchIfEmpty(Mono.error(() -> new RuntimeException("No reference table found with key " + referenceKey)))
    .map(referenceTable -> {
        logger.info("reference table: {}", referenceTable.toString());
        Market market = getMarket(aggregate.getDate(), aggregate.getMarket(), referenceTable);
        aggregate.setMarket(market);
        return aggregate;
    })
    .doOnError(e -> logger.info("Error getting reference table", e));