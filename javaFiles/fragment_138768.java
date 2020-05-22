while (rs.next()) {
    // ...
    String query = "insert into keys(employeeid,publickey) values (?, ?);"
    PreparedStatement psInsert = connection.prepareStatement(query);
    psInsert.setId(1, id);
    psInsert.setString(2, b64PublicKey);
    psInsert.executeUpdate();
}