public static String setLastSeenTime1(String time, TimeZone serverTimeZone) throws  ParseException {

   SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
   sdf.setTimeZone(serverTimeZone);

   SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
   sdf.setTimeZone(TimeZone.getDefault());

   return sdf2.format(sdf.parse(time));

}