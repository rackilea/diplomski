Date currentTime = Calendar.getInstance().getTime();

SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
String mDate = formatter.format(currentTime);

String URL_STRING = "https://api.data.gov.sg/v1/transport/taxi-availability?date_time=" + URLEncoder.encode(mDate, "utf-8");