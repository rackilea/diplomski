NewSet.coalesce(1).select("*")
        .write().format("com.databricks.spark.csv")
        .option("delimiter", ",")
        .option("header", "true")
        .option("treatEmptyValuesAsNulls", "true")  
        .option("nullValue", "")  
        .save(fileAbsolutePath);