Calendar cal = Calendar.getInstance();
long milliDiff = cal.get(Calendar.ZONE_OFFSET);
// Got local offset, now loop through available timezone id(s).
String [] ids = TimeZone.getAvailableIDs();
String name = null;
for (String id : ids) {
  TimeZone tz = TimeZone.getTimeZone(id);
  if (tz.getRawOffset() == milliDiff) {
    // Found a match.
    name = id;
    break;
  }
}
System.out.println(name);