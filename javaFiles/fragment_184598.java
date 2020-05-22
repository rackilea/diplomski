try {
       if (preparedStatement != null) {
            preparedStatement.close();
       }
       if (dbConnection != null) {
            dbConnection.close();
       }