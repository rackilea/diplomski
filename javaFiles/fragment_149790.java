//Getting the distinct columns
List<Row> distinctColumns = df.select("Employee").distinct().collectAsList();

//Initializing empty list for the new DataFrames
ArrayList<Dataset<Row>> newDFs = new ArrayList<>();

WindowSpec ws = Window.orderBy("date");

//Filtering by the distinct column values and adding to the list.
for (Row distinctColumn : distinctColumns) {
    String colName = distinctColumn.getString(0);

    newDFs.add(
            df.filter(col("Employee").$eq$eq$eq(colName))
                    .withColumn("rank", rank().over(ws))
    );
}

// show all the new DFs
for (Dataset<Row> aDF : newDFs) {
    aDF.show();
}