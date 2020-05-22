Statement statement = connection.createStatement();
try {
    ResultSet resultset = statement.executeQuery(sql);
    try {
        // read the resultset
    } finally {
        resultset.close();
    }
} finally {
    statement.close();
}