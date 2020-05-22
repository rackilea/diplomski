df.toJavaRDD().map(new Function<Row, String>() {
                    @Override
                    public String call(Row o) throws Exception {
                        return o.mkString("\t");
                    }
                }).coalesce(1).saveAsTextFile("/s/filelocation");