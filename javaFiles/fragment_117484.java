PreparedStatement ps = null;
    Connection con = null;
    // LIMIT 1 because you have one Person Object to fill otherwise you must be have an Array of Person
    String SQL = "SELECT * from usertable LIMIT 1";
    try {
        con = DBConnection.getConnection();
        ps = con.prepareStatement(SQL);

        ResultSet rs = ps.executeQuery();
        Person p = null;

        while (rs.next()) {
            p = new Person();
            p.id = rs.getInt(1);
            // or p.id=rs.getInt("userid"); by name of column
            p.name = rs.getString(2);
            // or p.name=rs.getString("firstname"); by name of column
        }
        return p;
    } catch (
        SQLException ex) {
        Logger.getLogger(YourClassName.class.getName()).log(Level.SEVERE, null, ex);
        return null;
    } finally {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(YourClassName.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(YourClassName.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }