try {
    connection = PgConnect.connect();
} catch (SQLException e) {
    System.out.println("Connection Failed! Check output console");
    e.printStackTrace();
    return;
}