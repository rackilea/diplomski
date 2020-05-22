String query = "SELECT city, COUNT(*) AS supplierCnt " + 
               "FROM supplier " + 
               "GROUP BY city " + 
               "ORDER BY city DESC";

ResultSet rs = st.executeQuery(query); 

while (rs.next()) {
    System.out.println(rs.getString("supplierCnt"));
    System.out.println(rs.getString("city"));
    space();
}