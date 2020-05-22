JavaPairRDD<String, String> cassandraKeyValuePairs = javaFunctions(sc).cassandraTable("player", "playerinfo").mapToPair(
            new PairFunction<CassandraRow, String, String>() {
                @Override
                public Tuple2<String, String> call(CassandraRow row) throws Exception {
                    return new Tuple2(row.getString("key1"), row.getLong("value"));
                }
            }
    );