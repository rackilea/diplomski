public static void main(String[] args) throws Exception {
    String host = "jdbc:mysql://localhost:3306/presearch";
    String username = "root";
    String password = "";
    String query = "update accounts set daily_search_count = daily_search_count + 1 where daily_search_count < 33";
    try (Connection con = DriverManager.getConnection(host, username, password);
            PreparedStatement updatexdd = con.prepareStatement(query)) {

        int updatexdd_done = updatexdd.executeUpdate();
    }
}