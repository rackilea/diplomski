Pipeline pipeline = Pipeline.create(options);

// Create tuple tags for the value types in each collection.
final TupleTag<TableRow> table1Tag = new TupleTag<>();
final TupleTag<TableRow> table2Tag = new TupleTag<>();

// Transform for keying table rows by session_id and cookie_id
WithKeys<String, TableRow> sessionAndCookieKeys = WithKeys.of(
    (TableRow row) ->
        String.format("%s#%s",
            row.get("session_id"),
            row.get("cookie_id")))
    .withKeyType(TypeDescriptors.strings());

/*
 * Steps:
 *  1) Read table 1's rows
 *  2) Read table 2's rows
 *  3) Map each row to a composite key
 *  4) Join on the composite key
 *  5) Process the results
 */
PCollection<KV<String, TableRow>> table1Rows = pipeline
    .apply(
        "ReadTable1",
        BigQueryIO
            .readTableRows()
            .from(options.getTable1()))
    .apply("WithKeys", sessionAndCookieKeys);

PCollection<KV<String, TableRow>> table2Rows = pipeline
    .apply(
        "ReadTable2",
        BigQueryIO
            .readTableRows()
            .from(options.getTable2()))
    .apply("WithKeys", sessionAndCookieKeys);

//Merge collection values into a CoGbkResult collection
PCollection<KV<String, CoGbkResult>> coGbkResult = KeyedPCollectionTuple
    .of(table1Tag, table1Rows)
    .and(table2Tag, table2Rows)
    .apply("JoinOnSessionAndCookie", CoGroupByKey.create());

// Process the results
coGbkResult.apply(
    "ProcessResults", 
    ParDo.of(new DoFn<KV<String, CoGbkResult>, Object>() {
      @ProcessElement
      public void processElement(ProcessContext context) {
        // Do something here
      }
    }));