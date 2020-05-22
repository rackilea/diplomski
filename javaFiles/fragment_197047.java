CreateGlobalSecondaryIndexAction stockIndex = new CreateGlobalSecondaryIndexAction()
            .withIndexName("StockIndex")
            .withKeySchema(
                    new KeySchemaElement().withAttributeName("stock").withKeyType(KeyType.HASH), // Partition key
                    new KeySchemaElement().withAttributeName("date").withKeyType(KeyType.RANGE)) // Sort key             
            .withProvisionedThroughput(new ProvisionedThroughput(20L, 20L))
            .withProjection(new Projection().withProjectionType(ProjectionType.KEYS_ONLY));