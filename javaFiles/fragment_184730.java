analytics.data().ga()
    .get(tableId,                  // Table Id.
        "2012-01-01",              // Start date.
        "2012-01-15",              // End date.
        "ga:pageviews")            // Metrics.
    .setDimensions("ga:pagePath")
    .setMaxResults(25);