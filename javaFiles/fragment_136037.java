//Connect to hbase
    Configuration config = HBaseConfiguration.create();
    Connection connection = ConnectionFactory.createConnection(config);

    //Create table
    final String TABLE1 = "table1";
    final String FAMILY1 = "family1";
    final String FAMILY2 = "family2";
    HBaseOps.createTable(connection, TABLE1, FAMILY1, FAMILY2);

    //Create table
    final String TABLE2 = "table2";
    final String FAMILY3 = "family3";
    final String FAMILY4 = "family4";
    HBaseOps.createTable(connection, TABLE2, FAMILY3, FAMILY4);