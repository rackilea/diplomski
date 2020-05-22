Connection connection = new getConnection();
Statement statement = connection.createStatement();
int i = 0;

for (String query : queries) {
    statement.addBatch("insert query");
    if ((i++ % 500) == 0) {
         // Do an execute now and again, don't send too many at once
        statement.executeBatch(); 
    }
}

statement.executeBatch();
statement.close();
connection.close();