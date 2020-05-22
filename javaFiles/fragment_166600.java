StructType customStructType = new StructType();

    customStructType = customStructType.add("first_name", DataTypes.StringType, true);
    customStructType = customStructType.add("last_name", DataTypes.StringType, true);
    customStructType = customStructType.add("age", DataTypes.IntegerType, true);

    ExpressionEncoder<Row> customTypeEncoder = null;
    Dataset<Row> changed_data = sqlDF.map(row->{
          return RowFactory.create(row.get(0),row.get(1), add_age(row.get(2)));
            }, RowEncoder.apply(customStructType));