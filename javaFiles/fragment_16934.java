ResultSet rs2 = statement.executeQuery();
while (rs2.next()) {
    String f = rs2.getString(1);
    System.out.println(f);
    int a = Integer.parseInt(f);
}