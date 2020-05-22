// Initializing possibleFormats somewhere only once
SimpleDateFormat[] possibleFormats = new SimpleDateFormat[] {
  new SimpleDateFormat("yyyy-MM-dd"),
  new SimpleDateFormat("yyyy,MM,dd"),
  new SimpleDateFormat("yyyy,MM,dd,HH,mm") };
for (SimpleDateFormat format: possibleFormats)
{
  format.setLenient(false);
}
// initializing ends

public Date parseDate(String date) {
  Date retVal = null;
  int index = 0;
  while (retVal == null && index < possibleFormats.length) {
    try {
      retVal = possibleFormats[index++].parse(date);
    } catch (ParseException ex) { /* Do nothing */ }
  }
  return retVal;
}