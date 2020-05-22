try {
    PreparedStatement ps = null;
    String sql = "SELECT TOP 1 TelephoneNumber FROM Application ";
           sql += "WHERE TelephoneNumber = ?;";
    ps = conn.prepareStatement(sql);
    ps.setString(1, "6553438888");
    ResultSet rs = ps.executeQuery();
    if (rs.next()) {
        System.out.println("Found the phone number");
    }
    else {
        System.out.println("Did not find the phone number");
    }
} catch (SQLException e) {
    // handle exception
} finally {
    // cleanup, close connections, etc.
}