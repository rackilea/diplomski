String start = "01/01/2009";
String end = "12/09/2013";
DateTimeFormatter pattern = DateTimeFormat.forPattern("dd/MM/yyyy");
DateTime startDate = pattern.parseDateTime(start);
DateTime endDate = pattern.parseDateTime(end);

List<DateTime> fridays = new ArrayList<>();
boolean reachedAFriday = false;
while (startDate.isBefore(endDate)){
    if ( startDate.getDayOfWeek() == DateTimeConstants.FRIDAY ){
        fridays.add(startDate);
        reachedAFriday = true;
    }
    if ( reachedAFriday ){
        startDate = startDate.plusWeeks(1);
    } else {
        startDate = startDate.plusDays(1);
    }
}