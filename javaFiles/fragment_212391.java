public boolean loginValidator(String userName, String password) {
    try{
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM user WHERE email = ? and password = ?");
        ps.setString(1, userName);
        ps.setString(2, password);
        ResultSet rst = ps.executeQuery();
        return rst.next(); // whether DB contains such record
    } catch(SQLException ex){
        ex.printStackTrace(); // TIP: use logging
    }
    return false;
}