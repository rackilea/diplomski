final String select = "select case when FHEIGHT_FLAG = 't' then 't' else 'f' end as FHEIGHT_FLAG, ....(all other columns) .... from tablename";
// database connection
Class driverClass = Class.forName("package.of.jdbcDriver");
Connection jdbcConnection = DriverManager.getConnection(
        "jdbc:url:of:db", "user", "pass");
IDatabaseConnection connection = new DatabaseConnection(jdbcConnection);

// partial database export
QueryDataSet partialDataSet = new QueryDataSet(connection);
partialDataSet.addTable("Tablename", select);

FlatXmlDataSet.write(partialDataSet, new FileOutputStream("mydataset.xml"));