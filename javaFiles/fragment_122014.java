List<StructField> fields = new ArrayList<>();
fields.add(DataTypes.createStructField("name", DataTypes.StringType, true));
fields.add(DataTypes.createStructField("age", DataTypes.StringType, true));
fields.add(DataTypes.createStructField("country", DataTypes.StringType, true));
StructType schema = DataTypes.createStructType(fields);

Dataset<Row> df = sparkSession.read().schema(schema).json(jsonSet);