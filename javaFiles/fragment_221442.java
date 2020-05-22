public static void runStandardSqlQuery(String queryString)
    throws TimeoutException, InterruptedException {
  QueryJobConfiguration queryConfig =
      QueryJobConfiguration.newBuilder(queryString)
          // To use standard SQL syntax, set useLegacySql to false.
          // See: https://cloud.google.com/bigquery/sql-reference/
          .setUseLegacySql(false)
          .build();

  runQuery(queryConfig);
}