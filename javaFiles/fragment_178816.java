private static List<String> returnFilteredResult(List<String> lines, String filter) {
    List<String> result = new ArrayList<>();
    for (String line : lines) {
        if (line.contains(filter)) {
            result.add(line);
        }
    }
    return result;
}

public ArrayList<String> cPyList(String filter) throws SQLException, NamingException {
    ArrayList<String> cPySearchList = new ArrayList<String>();
    CallableStatement ps = null;
    Connection conn = null;
    ResultSet rs = null;

    try {
        conn = DataUtility.getDataSource().getConnection();
        if (conn == null) {
            throw new SQLException("Can't get database connection");
        }
        ps = conn.prepareCall(strCPy);
        ps.clearParameters();
        ArrayList list = new ArrayList<>();
        rs = ps.executeQuery();

        while (rs.next()) {
            cPySearchList.add(rs.getString(1) + " (" + rs.getInt(2) + ")");
        }
    } finally {
        if (rs != null) {
            rs.close();
        }
        if (ps != null) {
            ps.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
    return returnFilteredResult(cPySearchList, filter);
}