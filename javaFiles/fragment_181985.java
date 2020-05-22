spark.read().format("org.apache.spark.sql.cassandra")
                .options(new HashMap<String, String>() {
                    {
                        put("keyspace", "wiki");
                        put("table", "treated_article");
                    }
                }).load();