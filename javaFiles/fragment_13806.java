cs = conn.prepareCall("{call getUserID(?)}");
      cs.setString(1, "user1");
      boolean hasResultSet =  cs.execute();
      if( hasResultSet ){
            rs = cs.getResultSet();
            if (rs.next()) {
                userId = rs.getInt(1);
            }
            System.out.println( "Userid = " + userId );
      }