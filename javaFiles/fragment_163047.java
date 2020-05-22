Connection con;
   PreparedStatement stmt;
   try {
        con = pool.getConnection();
        con.setAutoCommit(false);
        stmt = con.prepareStatement(...);
        stmt.setFloat(1, ...);
        stmt.setString(2, ...);
        stmt.executeUpdate();

        con.commit();
        stmt.close();
    } catch (SQLException e) {
        con.rollback();
    } finally {
        try {
           if(con!=null) 
               con.close();
           if(stmt!=null) {
               stmt.close();
        } catch (SQLException e) {
             ...
        } finally {

        }
    }