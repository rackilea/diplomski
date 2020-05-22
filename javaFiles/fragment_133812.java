String insertStr = "INSERT INTO  table1(username1,password1) VALUES(?, ?)";
try (PreparedStatement pst = con.prepareStatement(insertStr);) {
    pst.setString(1, a);
    pst.setString(2, b);
    pst.executeUpdate();
}