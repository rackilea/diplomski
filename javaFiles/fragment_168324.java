#register udf
spark.udf()
  .register("get_only_file_name", (String fullPath) -> {
     int lastIndex = fullPath.lastIndexOf("/");
     return fullPath.substring(lastIndex, fullPath.length - 1);
    }, DataTypes.StringType);

import org.apache.spark.sql.functions.input_file_name    

#use the udf to get last token(filename) in full path
Dataset<Row> initialDs = spark.read()
  .option("dateFormat", conf.dateFormat)
  .schema(conf.schema)
  .csv(conf.path)
  .withColumn("input_file_name", get_only_file_name(input_file_name()));