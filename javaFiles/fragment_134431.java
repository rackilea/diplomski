try (Connection c1 = DriverManager.getConnection("jdbc:h2:mem:1");
        Connection c2 = DriverManager.getConnection("jdbc:h2:mem:2")) {
    Statement s1 = c1.createStatement(), s2 = c2.createStatement();
    s1.execute("CREATE SCHEMA S; CREATE TABLE S.T1(ID INT); CREATE TABLE S.T2(ID INT)");
    try (ResultSet rs = s2.executeQuery("CALL LINK_SCHEMA('S', '', 'jdbc:h2:mem:1', '', '', 'S')")) {
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }
    }
}