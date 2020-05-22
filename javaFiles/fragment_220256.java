String databaseResult1, databaseResult2, fileResult1, fileResult2;


// Start looping
// ...

   databaseResult1 = rs.getString("ATTENDANT_NAME");
   fileResult1 = array[0];
   databaseResult2 = rs.getString("ATTENDANCE_TIME_DATE");
   fileResult2 = array[6];

   if(
       ( databaseResult1 == null && fileResult1 == null 
         || databaseResult1 != null && databaseResult1.equals(fileResult1) )
       &&
       ( databaseResult2 == null && fileResult2 == null 
         || databaseResult2 != null && databaseResult2.equals(fileResult2) )
      ...