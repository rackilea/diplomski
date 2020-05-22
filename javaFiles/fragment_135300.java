SparkSession spark = SparkSession
            .builder()
            .config(new SparkConf().setAppName("medianTest").setMaster("local[*]"))
            .getOrCreate();

    StructType schema = DataTypes.createStructType(new StructField[]{
            createStructField("subject", DataTypes.StringType, true),
            createStructField("student", DataTypes.StringType, true),
            createStructField("mark", DataTypes.IntegerType, true)
    });

    List<Row> rows = Arrays.asList(
            RowFactory.create("CS", "Alice", 85),
            RowFactory.create("CS", "Alice", 81),
            RowFactory.create("CS", "Alice", 97),
            RowFactory.create("CS", "Bob", 92),
            RowFactory.create("CS", "Bob", 75),
            RowFactory.create("CS", "Bob", 99),
            RowFactory.create("CS", "Carol", 71),
            RowFactory.create("CS", "Carol", 84),
            RowFactory.create("CS", "Carol", 91)
    );

    Dataset df = spark.createDataFrame(rows, schema);

    df
            .groupBy("subject", "student")
            .agg(
                    min("mark").as("min"),
                    max("mark").as("max"),
                    callUDF("percentile_approx", col("mark"), lit(0.5)).as("median")
            )
            .show();