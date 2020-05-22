public static void viewTable(Connection con)
    throws SQLException {

    Statement stmt = null;
    String query =
        "select color,count(*) Count from emp where (color like '%bl%' or color like'%ree%') group by color";

    try {
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            String color = rs.getString("color");
            int count = rs.getInt("Count");
            System.out.println("Color: " + color + " Count: " + count);
        }
    } catch (SQLException e ) {
        //Something
    } finally {
        if (stmt != null) { stmt.close(); }
    }
}