InputStream is = new URL("http://airbnb.com/ical/").openStream();
try {
   Calendar cal = new CalendarBuilder().build(is);
} finally {
  is.close();
}