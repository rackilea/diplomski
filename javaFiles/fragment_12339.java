static String queryCreateTable = "CREATE TABLE {0}" +
                                 "(ID INTEGER not NULL ," +
                                 "BRAND VARCHAR(40)," +
                                 "MODEL VARCHAR(40)," +
                                 "YEAR INTEGER not NULL," +
                                 "NOVELTY BINARY," +
                                 "PRIMARY KEY ( ID ))";