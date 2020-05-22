// get current date
SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
String a = dateFormat1.format(new Date());

// add current date to your time string
String dateString = a + " 4:16:06 PM";

SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd h:mm:ss a");
try {
    // parse it. This is you date object.
    Date d = dateFormat2.parse(dateString);
} catch (ParseException ex) {
    ex.printStackTrace();
}