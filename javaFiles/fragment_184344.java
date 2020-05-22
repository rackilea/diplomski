Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
PreparedStatement statement = connection.prepareStatement(JDBC_SELECT);
ResultSet rs = statement.executeQuery();
PrintStream out = System.out;

if (rs != null) {
    while (rs.next()) {
        ResultSetMetaData rsmd = rs.getMetaData();
        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
            if (i > 1) {
            out.print(",");
            }

            int type = rsmd.getColumnType(i);
            if (type == Types.VARCHAR || type == Types.CHAR) {
                out.print(rs.getString(i));
            } else {
                out.print(rs.getLong(i));
            }
        }

        out.println();
    }
}