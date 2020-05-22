SimpleDateFormat inputFormat = new SimpleDateFormat(
    "EEE MMM dd HH:mm:ss 'GMT' yyyy", Locale.US);
inputFormat.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));

SimpleDateFormat outputFormat = new SimpleDateFormat("MMM dd, yyyy h:mm a");
// Adjust locale and zone appropriately

Date date = inputFormat.parse(inputText);
String outputText = outputFormat.format(date);