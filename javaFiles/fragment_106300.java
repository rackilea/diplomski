public static void fillListFromDataBase (Connection conn, ObservableList<String> list) {
    String sql = "SELECT fieldName FROM transactions";
    try {
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sql))

        while(rs.next()) {
            list.add(rs.getString("fieldName"));
        }
    } catch(SQLException e) {
        e.printStackTrace();
    }
}