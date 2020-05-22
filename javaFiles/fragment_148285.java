// Copy
    Statement stf, stmt;
    Connection conf, cont;
    ResultSet rsf, rs;

    try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Class.forName("com.mysql.jdbc.Driver");
        conf = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:" + databaseFrom, "user1", "passwd1");
        try {
            stf = conf.createStatement();
            rsf = stf.executeQuery("select * from supplier order by sname");

            // read from rsf write to rs!
            cont = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + databaseTo, "user2", "passwd2");
            stmt = cont.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);


            rs = stmt.executeQuery("select * from supplier order by sname");

            while (rsf.next()) {
                rs.moveToInsertRow();

                rs.updateInt(1, rsf.getInt(1));
                rs.updateString(2, rsf.getString(2));
                rs.updateString(3, rsf.getString(3));
                rs.updateString(4, rsf.getString(4));
                rs.updateInt(5, rsf.getInt(5));
                rs.updateString(6, rsf.getString(6));
                rs.updateInt(7, rsf.getInt(7));
                rs.updateDouble(8, rsf.getDouble(8));
                rs.updateString(9, rsf.getString(9));

                rs.insertRow();
            }

        } catch (SQLException s) {
            JOptionPane.showMessageDialog(this, "problem creating database " + s);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, e.getStackTrace());
    } finally {
        if (stf != null) {
            try {
                stf.close();
                stmt.close();
            } catch (SQLException e) {
                // handle Exception
            }
        }
        if (conf != null) {
            try {
                conf.close();
                cont.close();
            } catch (SQLException e) {
                // handle Exception
            }
        }
    }