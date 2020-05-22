try (Connection connection=DriverManager.getConnection(mc.StrUrl,mc.StrUid,mc.StrPwd)) {
    String str="";
    str="select * from login where name = ? and password = ?";
    try (PreparedStatement pst=connection.prepareStatement(str)) {
        pst.setString(1, proid);
        pst.setString(2, proname);
        try (ResultSet rs = pst.executeQuery()) {
            while (rs.next() {
                //... Process each result...
            }
        }
    }
} catch (SQLException exp) {
    exp.printStackTrace();
}