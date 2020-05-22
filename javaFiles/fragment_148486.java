String string1 = "2016-11-23 00:00:00";
  DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  Date date1 = format.parse(string1);

   if(date1.equals(postgresDate)) { //postgresDate loaded from database
     //add your code
   }