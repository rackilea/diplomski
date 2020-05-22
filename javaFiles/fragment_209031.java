JavaSparkContext sc;
JavaRDD<String> data = sc.textFile("path/input.csv");
//JavaSQLContext sqlContext = new JavaSQLContext(sc); // For previous versions 
SQLContext sqlContext = new SQLContext(sc); // In Spark 1.3 the Java API and Scala API have been unified


JavaRDD<Record> rdd_records = sc.textFile(data).map(
  new Function<String, Record>() {
      public Record call(String line) throws Exception {
         // Here you can use JSON
         // Gson gson = new Gson();
         // gson.fromJson(line, Record.class);
         String[] fields = line.split(",");
         Record sd = new Record(fields[0], fields[1], fields[2].trim(), fields[3]);
         return sd;
      }
});