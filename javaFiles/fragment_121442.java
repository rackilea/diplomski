SubscribeOptions options = new SubscribeOptions.Builder()
        .setStrategy(Strategy.BLE_ONLY)
        // Note: If no filter is specified, Nearby will return all of your
        // attachments regardless of type. You must use a filter to specify
        // a particular set of attachments (by type) or to fetch attachments
        // in a namespace other than your project's default.
        .setFilter(new MessageFilter.Builder()
            .includeNamespacedType("some_namespace", "some_type")
            .build())
        .build();