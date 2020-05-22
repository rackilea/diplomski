String sql = "INSERT INTO table1 VALUES(?)";
PreparedStatement stmt = dbConnection.prepareStatement(sql);
for(LatLng s : list1){
    stmt.setString(1, s); // insert 's' in place of the 1st '?'
    stmt.addBatch();
}
stmt.executeBatch();