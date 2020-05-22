private void getTickersByNames(String fromtable, String totable) {
    try {
        String ticker;
        Connection con1 = DriverManager.getConnection("jdbc:derby://localhost:1527/mhjtestdatabase", null, null);
        Connection con2 = DriverManager.getConnection("jdbc:derby://localhost:1527/mhjtestdatabase", null, null);
        Connection con3 = DriverManager.getConnection("jdbc:derby://localhost:1527/mhjtestdatabase", null, null);

        sql = "SELECT * FROM APP." + totable;
        Statement stmt2 = con2.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs2 = stmt2.executeQuery(sql);

        rs2.beforeFirst();
        while (rs2.next()) {
            String name = rs2.getString("name");
            sql = "SELECT * FROM APP." + fromtable + " where name = '" + name + "'";
            Statement stmt1 = con1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs1 = stmt1.executeQuery(sql);
            rs1.first();
            if (rs1.getRow() == 0) {
                out("the name is not in 1st table" + name);
                rs1.close();
                stmt1.close();
                Statement stmt3 = con3.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                fromtable = "tsetmc";
                sql = "SELECT * FROM APP." + fromtable + " where name = '" + name + "'";
                ResultSet rs3 = stmt3.executeQuery(sql);
                rs3.first();
                if (rs3.getRow() == 0) {
                    out("the name is not in second too");
                    rs3.close();
                    stmt3.close();
                    continue;
                } else {
                    ticker = rs3.getString("ticker");
                    rs3.close();
                    stmt3.close();
                    rs2.updateString("ticker", ticker);
                    rs2.updateRow();
                    continue;
                }
            } else {
                ticker = rs1.getString("ticker");
                rs1.close();
                stmt1.close();
                rs2.updateString("ticker", ticker);
                rs2.updateRow();
            }
        }
        rs2.close();
        stmt2.close();
    } catch (SQLException ex) {
        Logger.getLogger(Frame_Ticker.class.getName()).log(Level.SEVERE, null, ex);
    }
}