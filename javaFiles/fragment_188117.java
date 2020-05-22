SparkConf sparkConf = new SparkConf().setAppName("Threshold")
            //.setMaster("local[4]");
            .setMaster(getMasterString(masterName))
            .set("spark.serializer",   "org.apache.spark.serializer.KryoSerializer")
            .registerKryoClasses(kryoClassArray);

    // create the JavaSparkContext now:
    JavaSparkContext jsc = new JavaSparkContext(sparkConf);