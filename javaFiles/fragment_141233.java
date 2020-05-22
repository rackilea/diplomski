private static void populateTypes(Connection connection)
        throws SQLException {

    String sql = "SELECT * FROM type";
    try (Statement st = connection.createStatement()) {
        try (ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                MyType.addType(name, id);
            }
        }
    }
}