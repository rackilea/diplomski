String sql = "INSERT INTO db1" +
            " (id,fname,lastname,username,password,usertype,email,contact,address)" +
            " VALUES (?,?,?,?,?,?,?,?,?)";
try (PreparedStatement stmt = conn.prepareStatement(sql)) {
    stmt.setInt   (1, id);
    stmt.setString(2, fname);
    stmt.setString(3, lastname);
    stmt.setString(4, username);
    stmt.setString(5, password);
    stmt.setString(6, usertype);
    stmt.setString(7, email);
    stmt.setString(8, contact);
    stmt.setString(9, address);
    stmt.executeUpdate();
}