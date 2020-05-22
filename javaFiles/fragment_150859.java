Pipeline pipeline = Pipeline.create(options);

    rows = pipeline.apply("Read from BQ", BigQueryIO.readTableRows().from(inputTable))
           .apply("Transform to row", ParDo.of(new RowParDo())).setRowSchema(SCHEMA);
    sumByCountry =rows.apply("Set Country key", MapElements.into(TypeDescriptors.kvs(TypeDescriptors.strings(), TypeDescriptors.integers()))
         .via((Row row) -> KV.of(row.getCountry(), row.getCount()))))
         .apply("Country Scores", Sum.<String>integersPerKey());
         .apply("Top Countries", Top.of(N, new CompareValues()))
     // Do the same for Session and page
     sumBySession = rows....
     sumByPage = rows....