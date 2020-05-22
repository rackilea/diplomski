protected void createContents() {
    ...
    Statement statement = null;
    try {
        statement = connect.createStatement();
        final Statement innerStatement = statement;
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    ...
}