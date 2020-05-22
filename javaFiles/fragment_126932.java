public static final String SOURCE_DATE_FORMAT = "yyyyMMddHHmmss";
String date = "20160908222020";

SimpleDateFormat sourceDateFormat = new SimpleDateFormat(SOURCE_DATE_FORMAT);
sourceDateFormat.setTimeZone("UTC"); // set this to whatever the source time zone is

String adjustedDate = "";
try {
    Date parsedDate = sourceDateFormat.parse(date);
    adjustedDate = DateFormat.getDateTimeInstance().format(parsedDate); // getDateTimeInstance() returns the local date/time format (in terms of language/locale and time zone) of the device and format() formats the parsed date to fit that instance
} catch (ParseException e) {
    e.printStackTrace();
}