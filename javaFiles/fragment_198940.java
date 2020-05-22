public void execute() {
    Dataset<Row> dataset = session.sql("select regexp_replace("test", '\\s+', ''") as key from master_table);
    JavaRDD<Row> rdd = context.parallelize(dataset.collectAsList(), factor);

    for (Row row : rdd.collect())
        System.out.println(row.getString(row.fieldIndex("key")));
}