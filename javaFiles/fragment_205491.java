Calendar c = Calendar.getInstance(TimeZone.getTimeZone(ZoneId.of("CET")));
c.set(Calendar.MONTH, 1)
c.set(Calendar.DAY_OF_MONTH, 5)
c.set(Calendar.HOUR_OF_DAY, 23);
c.set(Calendar.MINUTE, 59);
c.set(Calendar.SECOND, 59);
c.set(Calendar.MILLISECOND, 999);

while(true){
 Calendar cal = Calendar.getInstance(TimeZone.getTimeZone(ZoneId.of("CET")));
 if(cal.getTime().after(c.getTime()) return;
}