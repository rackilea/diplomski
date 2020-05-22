try {
    connection = database.getConnection();
    statement = connection.prepareStatement(SQL);
    setValues(statement, values);

    // ...