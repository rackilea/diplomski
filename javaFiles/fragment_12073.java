ResultSet rs = stmt.executeQuery();
while (rs.next()) {
    String id = rs.getString("ID");
    String name = rs.getNamex("NAME"); // Assuming there is a column called name.
    System.out.println(id);
}