sqlConnection.setAutoCommit(false);//<<------------
try {
    preparedStatement = sqlConnection.prepareStatement(sqlString);
    while ((csvLine = bufferedReader.readLine()) != null) {
        String[] splitLine = csvLine.split(";");
        preparedStatement.setBigDecimal(1, new BigDecimal(splitLine[4].trim()).setScale(2, RoundingMode.CEILING));
        preparedStatement.setBigDecimal(2, new BigDecimal(splitLine[5].trim()).setScale(2, RoundingMode.CEILING));
        preparedStatement.setInt(3, Integer.parseInt(splitLine[6].trim()));
        preparedStatement.setString(4, splitLine[2].trim());
        preparedStatement.setString(5, splitLine[8].trim());

        preparedStatement.addBatch();//<<-----------add a batch
    }

    //execute your multiple statement as one
    statement.executeBatch();//<<------------
    sqlConnection.commit();//<<--------------
}