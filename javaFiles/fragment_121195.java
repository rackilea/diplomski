sqlConnection.setAutoCommit(false);
try {
    int nbrBatch = 500;
    int count = 0;
    preparedStatement = sqlConnection.prepareStatement(sqlString);
    while ((csvLine = bufferedReader.readLine()) != null) {
        //Your code here
        preparedStatement.addBatch();
        if (count % nbrBatch == 0) {
            statement.executeBatch();
        }
        count++;
    }
    //rest of your batch not executed
    statement.executeBatch();
    sqlConnection.commit();
}