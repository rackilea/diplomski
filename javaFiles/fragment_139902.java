Connection c = DB.dbConnect(null);
    PreparedStatement s = null;
    ResultSet rs = null;
    try {
        final String SQL = " Select * from utilizador where Nome=? and Password=? and Permissao = ? ";

        s = c.prepareStatement(SQL);

        int i = 1;
        s.setString(i++, Username);
        s.setString(i++, Password);
        s.setInt(i++, Permissao);

        rs = s.executeQuery();
        if (rs.next()) {
             int permissao = rs.getInt("Permissao");
             String nome = rs.getString("Nome");
             String password = rs.getString("Password");
        }

    } catch (SQLException e) {          
        // exception handler
    } finally {
        try {
            if (rs != null)
                rs.close();
        } catch (Exception e) {
        }
        try {
            if (s != null)
                s.close();
        } catch (Exception e) {
        }try {
            if (c != null)
                c.close();
         } catch (Exception e) {
        }
    }