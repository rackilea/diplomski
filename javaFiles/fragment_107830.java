String selectTableSQL = "SELECT * FROM diseaseinfo WHERE col1 = ? and col2 = ?";
try (PreparedStatement ps = connection.prepareStatement(selectTableSQL)) {

    ps.setString(1, value_1);
    ps.setString(2, value_2);
    ResultSet rs = ps.executeQuery();
    while(rs.next()){
        //...
    }
}