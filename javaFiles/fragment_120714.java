GregorianCalendar calendarStart = new GregorianCalendar(2015, 2, 1);
GregorianCalendar calendarEnd = new GregorianCalendar(2015, 2, 28);

List<Integer> includedDays = Arrays.asList(GregorianCalendar.THURSDAY, GregorianCalendar.FRIDAY);
long count = 0;
while(!calendarStart.equals(calendarEnd)) {
    if(includedDays.contains(calendarStart.get(Calendar.DAY_OF_WEEK))) {
        count ++;
    }
    calendarStart.add(Calendar.DATE, 1);
}