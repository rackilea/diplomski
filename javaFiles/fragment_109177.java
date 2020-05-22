DateFormat userDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); //time format from server
DateFormat dateFormatNeeded = new SimpleDateFormat("yyyy-MM-dd"); // time format needed
Date newDate = null;
try {
    newDate = userDateFormat.parse(date); // this parses server date format
} catch (ParseException e) {
    e.printStackTrace();
}
//this converts to required date format
String convertedDate = dateFormatNeeded.format(newDate);
return convertedDate;