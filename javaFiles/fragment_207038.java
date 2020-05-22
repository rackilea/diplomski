public long getTime(String time) throws ParseException {
  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSS'Z'");
  Date date = df.parse(time);

  return date.getTime();
}