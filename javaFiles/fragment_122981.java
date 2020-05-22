void whatever {

   Connection conn = null;
   Statement  st1 = null;

   try {
       st1 = conn.createStatement();

   }  catch (SQLException e) { 
      e.printStackTrace();
   }  finally { 
      try {
          st1.close();
          rs1.close();
          rs2.close();
          conn.close();
      } catch (SQLException ex) {
          //
      } 
   }
}