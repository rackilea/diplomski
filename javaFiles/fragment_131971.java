SparkSession spark = SparkSession
    .builder()
    .appName("Java Spark Hive Example")
    .master("local[*]")
    .config("hive.metastore.uris", "thrift://localhost:9083")
    .enableHiveSupport()
    .getOrCreate();

spark.sql("select count(*) from health1").show();