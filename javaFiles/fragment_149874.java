public static String convertLocalTimeToUTC(String saleTimeZone, String p_localDateTime) throws Exception{

  String dateFormateInUTC="";
  Date localDate = null;
  String localTimeZone ="";
  SimpleDateFormat formatter;
  SimpleDateFormat parser;
  localTimeZone = saleTimeZone;

  //create a new Date object using the timezone of the specified city
  parser = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
  parser.setTimeZone(TimeZone.getTimeZone(localTimeZone));
  localDate = parser.parse(p_localDateTime);
  formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss z'('Z')'");
  formatter.setTimeZone(TimeZone.getTimeZone(localTimeZone));
  System.out.println("convertLocalTimeToUTC: "+saleTimeZone+": "+" The Date in the local time zone " +   formatter.format(localDate));

  //Convert the date from the local timezone to UTC timezone
  formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
  dateFormateInUTC = formatter.format(localDate);
  System.out.println("convertLocalTimeToUTC: "+saleTimeZone+": "+" The Date in the UTC time zone " +  dateFormateInUTC);

 return dateFormateInUTC;
 }

  public static void main(String arg[]) throws Exception
    {

        convertLocalTimeToUTC("EST", "12-03-2013 10:30:00");
        convertLocalTimeToUTC("PST", "12-03-2013 10:30:00");
    }