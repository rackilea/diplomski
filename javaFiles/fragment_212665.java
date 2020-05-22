from(endpointsURLs.get(START_AGENT))
            .bean(databaseFetch, "fetch")
            .split().method(SplittingStrategy.class, "splitItems")
                .parallelProcessing()
                .bean(databaseBatchExtractor, "launch")
            .end()
            .to("seda:generateExportFiles");

    from("seda:generateExportFiles")
            .bean(databaseFetch, "fetchPublications")
            .multicast()
            .parallelProcessing()
            .to("direct:generateJson", "direct:generateCsv");

    from("direct:generateJson")
            .log("generate JSON file")
            .marshal()
            .json(JsonLibrary.Jackson, true)
            .setHeader(Exchange.FILE_NAME, constant("extract.json")))
            .to("file:/json?doneFileName=${file:name}.done")
            .to("direct:notify");

    from("direct:generateCsv")
            .log("generate CSV file")
            .bean(databaseFetch, "exportCsv")
            .to("direct:notify");

    from("direct:notify")
            .log("generation done");