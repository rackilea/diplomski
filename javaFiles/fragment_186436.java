private String shiftCount() {
  Calendar time = Calendar.getInstance();
  // the hours is always >= 0
  if (time.get(Calendar.HOUR_OF_DAY) <  6) return "-S1";
  if (time.get(Calendar.HOUR_OF_DAY) < 14) return "-S2";
  if (time.get(Calendar.HOUR_OF_DAY) < 22) return "-S3";
  // the hour is always < 24.
  return "-S1";   
}