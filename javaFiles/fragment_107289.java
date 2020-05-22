int size = 5;
String strSQL = "insert into multiplication values (?)"; 
try(PreparedStatement ps = conn.prepareStatement(strSQL)) {
     for(int i = 1; i <= size; i++) {
         for(int j = 1; j <= size; j++) {
             int x = i * j;
             ps.setInt(1, x);
             ps.addBatch(); // The statement is added to the batch (but not executed yet)
         }
     }
     ps.executeBatch(); // All the instructions in the batch are executed HERE
 } catch(SQLException e) {
     // Exception handling code
 }