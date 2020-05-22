public static InputStream getTheDbFileInputStreamWhereId(String id) {

    try {
        String sql = "select songFile from songs where id= ?";
        Connection con = getConnectionGp();
        PreparedStatement stat = con.prepareStatement(sql);
        stat.setString(1, id);
        ResultSet result = stat.executeQuery();
        if (result.next()) {
            return result.getBinaryStream(1);
        }
    } catch (Exception e) {
        System.out.println("prolbem in dao dwonload");
        e.printStackTrace();
    }
    return null;
}