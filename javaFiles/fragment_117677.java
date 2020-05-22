public List<Product> getProducts(String categoryName) {
    String sql = "SELECT id, name FROM Product WHERE categoryName = ?";
    List<Product> productList = new ArrayList<Product>();
    DBConnection dbConnection = new DBConnection();
    try {
        dbConnection.open();
        ResultSet resultSet = dbConnection.executeSelect(sql, categoryName); //execute select and apply parameters
        //fill productList...
    } catch (Exception e) {
        //always handle your exceptions
        ...
    } finally {
        //don't forget to also close other resources here like ResultSet...
        //always close the connection
        dbConnection.close();
    }
}