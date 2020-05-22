Statement statement = conection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
ResultSet rs = statement.executeQuery("SELECT * FROM ITEMS");
while (rs.next()) {
    int count = rs.getInt("COUNT");
    if(count > 0) {
        rs.updateInt("COUNT", 0);
        rs.updateRow();
    }
}