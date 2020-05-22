private final String PRODECURE_NAME = "{? = call <ProcedureName>(?,?,?)}";

Connection con = null;
CallableStatement cs = null;

       try {
            con = DAOFactory.getDatabaseConnection();
            cs = con.prepareCall(PRODECURE_NAME);
            cs.registerOutParameter(1, java.sql.Types.ARRAY);
            cs.setYourType(2, <yourData>);
            cs.setYourType(3, <yourData>);
            cs.setYourType(4, <yourData>);
            cs.execute();
            Array arr = cs.getArray(1);
            if (arr != null) {
               String[] data = (String[]) arr.getArray();
            }
        } 
        catch (SQLException ex) {
            Logger.getLogger(OracleLiekDAO.class.getName()).log(Level.SEVERE, null, ex);
            try {
                con.rollback();
            }
        }
        finally {
            if (con != null) {
                try {
                    con.close();
                } 
                catch (SQLException ex) {
                    Logger.getLogger(OracleLiekDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }