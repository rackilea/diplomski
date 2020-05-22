df.groupByKey(new MapFunction<Row, Bean>() {
            @Override
            public Bean call(Row row) throws Exception {
                return new Bean(row.getString(0), row.getInt(1));
            }
        }, Encoders.bean(Bean.class));