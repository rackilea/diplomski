/**
* This method is used to get the Execution Time
* by calculating the difference between StartTime and EndTime
* 
* @param StartTime Execution Start Time
* @param EndTime Execution End Time
* @return Total Execution Time
*/
 private static String ExecutionTime(String StartTime, String EndTime){

   LocalTime fromDateTime = LocalTime.parse(StartTime);
   LocalTime toDateTime = LocalTime.parse(EndTime);

   LocalTime tempDateTime = LocalTime.from( fromDateTime );

   long hours = tempDateTime.until( toDateTime, ChronoUnit.HOURS);
   tempDateTime = tempDateTime.plusHours( hours );

   long minutes = tempDateTime.until( toDateTime, ChronoUnit.MINUTES);
   tempDateTime = tempDateTime.plusMinutes( minutes );

   long seconds = tempDateTime.until( toDateTime, ChronoUnit.SECONDS);


   if(hours > 0){
       return hours + "h " +minutes + "min " + seconds + "s";
   }else{
       return minutes + "min " + seconds + "s";
   }

}