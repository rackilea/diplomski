try (CallableStatement cstmt = connection.prepareStatement(
        "{call yourProcedure(?, ?, ?)}")) {
    cstmt.setString(1, "value1");
    cstmt.setString(2, "value2");
    cstmt.setString(3, "value3");
    try (ResultSet rs = cstmt.executeQuery()) {
        while(rs.next()) {
            // do something with result set rows ...
        }
    }
}