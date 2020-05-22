if (timestampText.endsWith(" IST")) {
  timestampText = timestampText.substring(0, timestampText.length() - 4);
}

SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
sdf.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
java.util.Date d = sdf.parse(timestampText);