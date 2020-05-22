private ZoneId getZoneOffsetFor(final Date date, final TimeZone timeZone){
  int offsetInMillis = getOffsetInMillis(date, timeZone);
  return ZoneOffset.ofTotalSeconds( offsetInMillis / 1000 );
}

private int getOffsetInMillis(final Date date, final TimeZone timeZone){
  int offsetInMillis = timeZone.getRawOffset();
  if(timeZone.inDaylightTime(date)){
     offsetInMillis += timeZone.getDSTSavings();
  }
  return offsetInMillis;
}