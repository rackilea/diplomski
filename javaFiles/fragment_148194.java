try {
    Connection con1 = (Connection) DriverManager.getConnection(url, username, password);
    String query = "INSERT INTO Data (Col1,Col2,Col3) VALUES (?,?,?)";
    PreparedStatement pst1 = (PreparedStatement) con1.prepareStatement(query); 
    for (int i = 0; i < table.size(); i++) {
        pst1.clearParameters();            
        pst1.setString(1, table.get(i).get(0));
        pst1.setString(2, table.get(i).get(1)); 
        pst1.setString(3, table.get(i).get(2));                 
        pst1.addBatch();
    }
    pst1.executeBatch();
    return true;
} catch (SQLException e) {
    return false;
} finally {
    //close everything
}