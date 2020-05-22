ResultSet rs2 = statement.executeQuery();
String f = null;
while (rs2.next()) {
    f = rs2.getString(1);
    System.out.println(f);
}
int a = Integer.parseInt(f);