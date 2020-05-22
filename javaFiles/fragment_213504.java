// get system's default timezone
ZoneId zone = ZoneId.systemDefault();

// or even better, get a specific timezone (more details on that below)
ZoneId zone = ZoneId.of("Europe/Kiev");


// start and end working hours
LocalTime workStart = LocalTime.of(10, 0);
LocalTime workEnd = LocalTime.of(18, 0);

// start and end dates
ZonedDateTime start = ZonedDateTime.of(2017, 7, 10, 15, 0, 0, 0, zone);
ZonedDateTime end = ZonedDateTime.of(2017, 7, 12, 13, 0, 0, 0, zone);

long totalHours = 0;
ZonedDateTime startHour = start;
// if start is before 10AM or 6PM, adjust it
if (start.toLocalTime().isBefore(workStart)) { // before 10 AM
    startHour = start.with(workStart); // set time to 10 AM
} else if (start.toLocalTime().isAfter(workEnd)) { // after 6 PM
    startHour = start.with(workEnd); // set time to 6 PM
}
ZonedDateTime endHour = end;
// if end is before 10AM or 6PM, adjust it
if (end.toLocalTime().isAfter(workEnd)) { // after 6 PM
    endHour = end.with(workEnd); // set time to 6 PM
} else if (end.toLocalTime().isBefore(workStart)) { // before 10 AM
    endHour = end.with(workStart); // set time to 10 AM
}

while(startHour.isBefore(endHour)) {
    if (startHour.toLocalDate().equals(endHour.toLocalDate())) { // same day
        totalHours += ChronoUnit.HOURS.between(startHour, endHour);
        break;
    } else {
        ZonedDateTime endOfDay = startHour.with(workEnd); // 6PM of the day
        totalHours += ChronoUnit.HOURS.between(startHour, endOfDay);
        startHour = startHour.plusDays(1).with(workStart); // go to next day
    }
}

System.out.println(totalHours); // 14