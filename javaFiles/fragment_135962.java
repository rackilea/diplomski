DateTimeZone zone = DateTimeZone.forID(user.getTimezone());
// Defaults to the current time. I'm not a fan of this - I'd pass in the
// relevant instant explicitly...
DateTime nowInZone = new DateTime(zone);
LocalDate today = nowInZone.toLocalDate();
DateTime startOfToday = today.toDateTimeAtStartOfDay(zone);
DateTime startOfTomorrow = today.plusDays(1).toDateTimeAtStartOfDay(zone);

event.setStartTime(startOfToday.toDate());
event.setEndTime(startOfTomorrow.toDate());