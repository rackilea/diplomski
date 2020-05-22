String text = "WEDNESDAY 21st JAN 2012 - 12:44:07 PM";
String[] parts = text.split(" ", 3);  // we only need 3 parts. No need splitting more
parts[1] = parts[1].substring(0, 2);
String parseableText = String.format("%s %s %s", parts[0], parts[1], parts[2]);  
SimpleDateFormat sdf = new SimpleDateFormat("EEEE dd MMM yyyy - hh:mm:ss aa" );

try {
    java.util.Date dt = sdf.parse(parseableText);
} catch (ParseException e) {
    e.printStackTrace();
}