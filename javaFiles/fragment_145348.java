// Date to parse
String dateString = "Tue, 06 Nov 2012 5:30 pm LST";

// This parser works with some timezones but fails with ambiguous ones...
DateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy h:mm a zzz");

Date date = null;  
try {
    // Try to parse normally
    date = dateFormat.parse(dateString);
} catch (ParseException e) {
    // Failed, try to parse with a GMT timezone as a workaround.
    // Replace the last 3 characters with "GMT"
    dateString = dateString.replaceFirst("...$", "GMT");
    // Parse again
    date = dateFormat.parse(dateString);
}