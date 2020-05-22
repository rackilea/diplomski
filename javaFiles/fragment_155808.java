SparkSession spark = SparkSession
            .builder()
            .master("local")
            .appName("SO")
            .getOrCreate();

Dataset<Row> df1 = spark.read().json("src/main/resources/json/Dataset.json");
df1.printSchema();
df1.show();

Dataset<Row> df1Map = df1.select(functions.array("beginTime", "endTime"));
df1Map.show();