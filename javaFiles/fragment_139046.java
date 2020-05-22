Connection conn = DriverManager.getConnection("jdbc:neo4j://localhost:7474/");
ResultSet rs = conn.executeQuery("start n=node({id}) return id(n) as id", map("id", id));

while(rs.next()) {
    System.out.println(rs.getLong("id"));
}