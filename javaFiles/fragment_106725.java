public void execute(String query, Object ... params) throws SQLException {
    //assumes you already have your Connection
    PreparedStatement pstmt = con.prepareStatement(query);
    int i = 1;
    for(Object param : params) {
        pstmt.setObject(i++, param);
    }
    pstmt.executeUpdate();
    pstmt.close();
}