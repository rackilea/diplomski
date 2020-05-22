try (CallableStatement cstmt = connection.prepareStatement(
        "{call yourProcedure(?, ?, ?)}")) {
    cstmt.setString(1, "value1");
    cstmt.setString(2, "value2");
    cstmt.setString(3, "value3");
    cstmt.execute();
}