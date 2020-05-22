private Boolean executeInsertQuery(Connection conn, String schoolID, String branchID,
            String studentName, String parentName, String emailId,
            String password, String className, String section,
            int age, String dob, String scholarNo, String address,
            String contactNo, int rollType) throws SQLException {
    boolean isSuccess = false;
    String getDBUSERByUserIdSql = "{call insertChildAndParentDetails(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
    try (CallableStatement callableStatement = conn.prepareCall(getDBUSERByUserIdSql)) {
        callableStatement.setString(1, scholarNo);
        callableStatement.setString(2, schoolID);
        callableStatement.setString(3, branchID);
        callableStatement.setString(4, studentName);
        callableStatement.setString(5, className);
        callableStatement.setString(6, section);
        callableStatement.setInt(7, age);
        callableStatement.setString(8, dob);
        callableStatement.setString(9, emailId);
        callableStatement.setString(10, branchID);
        callableStatement.setString(11, schoolID);
        callableStatement.setString(12, studentName);
        callableStatement.setString(13, scholarNo);
        callableStatement.setString(14, contactNo);
        callableStatement.setString(15, password);
        callableStatement.setInt(16, rollType);
        callableStatement.setString(17, parentName);
        callableStatement.setString(18, address);
        isSuccess = (callableStatement.executeUpdate() > 0);
    } catch (SQLException e) {
        System.out.println("## we have an exception" + e.getMessage());
    }
    return isSuccess;
}