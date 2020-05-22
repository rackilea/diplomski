SimpleDateFormat df = new SimpleDateFormat("EEE MMM d HH:mm:ss Z yyyy");  

Date formattedDate = null;
try {
   formattedDate = df.parse("Tue May 31 17:46:55 +0800 2011");
} catch (ParseException e) {
  e.printStackTrace();
}