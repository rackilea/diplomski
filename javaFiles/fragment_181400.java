OpenCalendar openCal = new OpenCalendar();
openCal.add(DateTimeConstants.MONDAY   , new LocalTime(10, 0), new LocalTime(18, 0));
openCal.add(DateTimeConstants.TUESDAY  , new LocalTime(10, 0), new LocalTime(18, 0));
openCal.add(DateTimeConstants.WEDNESDAY, new LocalTime(10, 0), new LocalTime(18, 0));
openCal.add(DateTimeConstants.THURSDAY , new LocalTime(10, 0), new LocalTime(18, 0));
openCal.add(DateTimeConstants.FRIDAY   , new LocalTime(10, 0), new LocalTime(18, 0));

LocalDateTime now = LocalDateTime.now();
if (openCal.isOpen(now)) {
    // code here
}