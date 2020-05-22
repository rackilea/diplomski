ZoneId zoneId = ZoneId.of("America/Los_Angeles");
long currMillis = 2530778400000L;
Instant curr = Instant.ofEpochMilli(currMillis);
TimeZone tz = TimeZone.getTimeZone(zoneId);

// what's the actual offset at that instant?
System.out.println(zoneId.getRules().getOffset(curr).getTotalSeconds());
System.out.println(tz.getOffset(currMillis) / 1000);

// is DST observed at that instant?
System.out.println(zoneId.getRules().isDaylightSavings(curr));
System.out.println(tz.inDaylightTime(new Date(currMillis)));

// what's the standard offset at that instant?      
System.out.println(zoneId.getRules().getStandardOffset(curr).getTotalSeconds());
System.out.println(tz.getRawOffset() / 1000);

// how many seconds does DST add to the standard offset at that instant?
System.out.println(zoneId.getRules().getDaylightSavings(curr).getSeconds());
Calendar calendar = GregorianCalendar.from(ZonedDateTime.ofInstant(curr, zoneId));
System.out.println(calendar.get(Calendar.DST_OFFSET) / 1000);