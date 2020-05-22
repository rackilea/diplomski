conn = getConnection();
String query = "SELECT EXISTS(SELECT NULL FROM my_table WHERE number = ? LIMIT 1)";
pstmt = conn.prepareStatement(query);
pstmt.setString(1, myId); // Or setInt or whatever
rs = pstmt.executeQuery();
if (rs.next()) {
    boolean exists= rs.getBoolean(1);
    System.out.println("exists= " + exists);
} else {
    System.out.println("error: could not get the record counts");
}