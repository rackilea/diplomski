Seq<String> columns = /* ... */;

Dataframe<Row> newDf = df.select(
    columns.apply(0), // first element
    columns.slice(1, columns.size()) // from the second to the end
);