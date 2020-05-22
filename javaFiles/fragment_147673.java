//Get NY time zone instance
TimeZone ny_tz = TimeZone.getTimeZone("America/New_York");

//Get NY calendar object with current date/time
Calendar ny_cal = Calendar.getInstance(ny_tz);

//Get offset from UTC, accounting for DST
int ny_offset_ms = ny_cal.get(Calendar.ZONE_OFFSET) + ny_cal.get(Calendar.DST_OFFSET);