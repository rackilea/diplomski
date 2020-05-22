List<String> stringAsList = new ArrayList<String>();
        stringAsList.add("buzz");

JavaRDD<Row> rowRDD = sparkContext.parallelize(stringAsList).map((String row) -> {
                return RowFactory.create(row);
            });

StructType schema = DataTypes.createStructType(new StructField[] { DataTypes.createStructField("fizz", DataTypes.StringType, false) });

DataFrame df = sqlContext.createDataFrame(rowRDD, schema).toDF();
df.show();

//+----+
|fizz|
+----+
|buzz|