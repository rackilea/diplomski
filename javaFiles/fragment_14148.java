public class DbUtil {
   public static void executeBatchUpdate(Connection con, 
                                         String stmt
                                         List<Object[]> data) {
      PreparedStatement p = con.prepareStatement(stmt);
      for (Object[] rowData : data) {
         for (int i = 0; i < rowData.length; i++) {
            p.setObject(i+1, rowData[i]);
         }
         p.addBatch();
      }
      int[] results = p.executeBatch();
      // check results
      // handle exceptions
      // return something if needed
   }
}