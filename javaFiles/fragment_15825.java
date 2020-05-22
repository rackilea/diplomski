long count = df.count();
long inc = count / 10;
for (long i = 0; i < count; i += inc) {
  Dataset<Row> filteredDf =
      df.where("id>=" + i + " AND id<" + (i + inc));

  List<Row> rows = filteredDf.collectAsList();
  for (Row r : rows) {
    System.out.printf("%d: %s\n", r.getAs(0), r.getString(1));
  }
}