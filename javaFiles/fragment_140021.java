System.out.println("Starting");
System.out.println(Arrays.toString(args));
Row sampleRow = sparkSession.read().parquet(readFrom).head();
ExpressionEncoder<Row> rowEncoder = RowEncoder.apply(sampleRow.schema());

//read all elements, process and write back the result
sparkSession.read()
            .parquet(readFrom)
            .groupByKey((MapFunction<Row, Long>) value -> {
                long stamp = value.getAs("timeStamp");
                return stamp / 600000;
            }, Encoders.LONG())
            .reduceGroups((ReduceFunction<Row>) (v1, v2) -> {
                int fare1 = v1.getAs("totalFare");
                int fare2 = v2.getAs("totalFare");
                return fare1 < fare2 ? v1 : v2;
            })
            .map((MapFunction<Tuple2<Long, Row>, Row>) Tuple2::_2, rowEncoder)
            .write()
            .parquet(writeTo);
System.out.println("Done !!!!");