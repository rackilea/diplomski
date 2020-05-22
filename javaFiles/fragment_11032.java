Calendar cSchedStartCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
long gmtTime = cSchedStartCal.getTime().getTime();

long timezoneAlteredTime = gmtTime + TimeZone.getTimeZone("Asia/Calcutta").getRawOffset();
Calendar cSchedStartCal1 = Calendar.getInstance(TimeZone.getTimeZone("Asia/Calcutta"));
cSchedStartCal1.setTimeInMillis(timezoneAlteredTime);