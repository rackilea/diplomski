public static void main(String[] args) {
    Connection con = new DBConnection().Connect();
    String sql = "INSERT INTO nameTable (name) values (?)";
    PreparedStatement stmt;
    try {
        stmt = con.prepareStatement(sql);
        List<String> names = new ArrayList();
        names.add("John");
        names.add("Sally");
        names.add("Rob");
        for (String name : names) {
            stmt.setString(1, name);
            stmt.execute();
        }
        stmt.close();
        con.close();
    } catch (SQLException ex) {
        System.err.println("Error = " + ex);
    }
}}