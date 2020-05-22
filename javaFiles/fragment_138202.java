sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
try {
  Date nd = sdf.parse(newDate);
  return nd;
} catch (ParseException e) {
   return null;
}