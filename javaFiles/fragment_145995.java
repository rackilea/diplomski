try (CallableStatement cstmt = connection.prepareStatement(
        "{call yourProcedure(?, ?, ?, ?, ?)}")) {
    cstmt.setString(1, "value1");
    cstmt.setString(2, "value2");
    cstmt.setString(3, "value3");
    cstmt.registerOutParameter(4, Types.VARCHAR);
    cstmt.registerOutParameter(5, Types.VARCHAR)
    cstmt.execute();

    String out1 = cstmt.getString(4);
    String out2 = cstmt.getString(5);
    // do something with result
}