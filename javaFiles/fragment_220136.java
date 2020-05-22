StructType schema = DataTypes.createStructType(new StructField[] { 
    DataTypes.createStructField("name", DataTypes.StringType, true),
    DataTypes.createStructField("salary", DataTypes.IntegerType, true),
    DataTypes.createStructField("occupation", DataTypes.StringType, true),
    DataTypes.createStructField("address", DataTypes.StringType, true)});

DataFrame df = sqlContext.read().schema(schema).json(jsonPath);
df.printSchema();
df.show(false);