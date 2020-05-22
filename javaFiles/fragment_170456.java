public static ResultSet executeQuery(String SQL, String dbName)
{
    CachedRowSetImpl crs = new CachedRowSetImpl();
    ResultSet rset = null ;
    Statement st = null;
    try {
           st = DatabaseManager.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
           rset = st.executeQuery(SQL);
           crs.populate(rset);
    }
    catch (SQLException e) {
        System.out.println(e.getMessage());
        System.exit(0);
    }finally{
        rset.close();
        st.close();
    }
    return crs;
 }