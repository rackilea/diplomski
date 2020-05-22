public boolean checkId(int id) {
    String sql = "Select 1 from MyTable where id = ?";  

    PreparedStatement ps = dbConn.prepareStatement(sql);
    ps.setString(1, id);
    ResultSet rs = ps.executeQuery();

    return rs.next();
}