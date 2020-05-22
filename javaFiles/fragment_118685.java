ZoneId zoneId = ZoneId.of ( "America/Montreal" );
ZonedDateTime now = ZonedDateTime.now ( zoneId );
LocalDate firstDayOfThisWeek = now.toLocalDate ().with ( DayOfWeek.MONDAY );
LocalDate firstDayOfNextWeek = firstDayOfThisWeek.plusWeeks ( 1 );
ZonedDateTime thisWeekStart = firstDayOfThisWeek.atStartOfDay ( zoneId );
ZonedDateTime nextWeekStart = firstDayOfNextWeek.atStartOfDay ( zoneId );