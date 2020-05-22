try (Connection connection=DriverManager.getConnection(mc.StrUrl,mc.StrUid,mc.StrPwd)) {
    String str="";
    str="INSERT INTO login('uname', 'password') VALUES (?, ?)";
    try (PreparedStatement pst=connection.prepareStatement(str)) {
        pst.setString(1, proid);
        pst.setString(2, proname);
        int count=pst.executeQuery();
        System.out.println(count + " rows changed");
    }
} catch (SQLException exp) {
    exp.printStackTrace();
}