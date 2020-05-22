finally 
    {
          if( stmt != null ) {
            try {
              stmt.close();
            }
            catch(SQLException ex ) {
              ex.printStackTrace();
            }
          }
    }