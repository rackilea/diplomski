SparkSession spark= SparkSession.builder()
                                .appName("JavaWord2VecExample")
                                .master("spark://master:7077")
                                .config("spark.dynamicAllocation.enabled", true)
                                .config("spark.shuffle.service.enabled", true)
                                .config("spark.storage.memoryFraction", "1")
                                .getOrCreate();