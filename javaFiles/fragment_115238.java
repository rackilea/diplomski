public static void main(String[] args) throws SQLException {
    for (int i = 0; i < queries.length; i++) {
        PreparedStatement stmt = conn.prepareStatement(queries[i]);
        try {          
            if (queries[i].toUpperCase().contains("SELECT ") && !queries[i].toUpperCase().contains("CREATE ") && !queries[i].toUpperCase().contains("DROP ") && !queries[i].toUpperCase().contains("DELETE ")) {
                rs = stmt.executeQuery();
            } else {
                stmt.executeUpdate();
            }
        } finally {
            stmt.close();
        }
    }
}