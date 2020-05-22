while (rs.next()) {
    System.out.println("phoneFirst" + rs.getString("phone"));
}

 rs.beforeFirst(); 

while (rs.next()) {
    System.out.println("phoneSecond" + rs.getString("phone"));
}