String arr = null;
while (rs.next()) {
    String em = rs.getString("EM_ID");
    arr = em.replace("\n", ",");
    System.out.println(arr);
}