static UDF1 BytesSize = new UDF1<String, Integer>() {
    public Integer call(final String line) throws Exception {
        return line.getBytes().length;
    }
};

private void saveIt(){

sparkSession.udf().register("BytesSize",BytesSize,DataTypes.IntegerType);
    dfToWrite.withColumn("fullLineBytesSize",callUDF("BytesSize",functions.concat_ws( ",",columns)) ).write().partitionBy(hivePartitionColumn)
                    .option("header", "true")
                    .mode(SaveMode.Append).format(storageFormat).save(pathTowrite);
}