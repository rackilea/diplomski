//assume date1 < date2

List<Date> dateList = new LinkedList<Date>();
for (long t = date1.getTime(); t < date2.getTime() ; t += DAY_IN_MILLIS) {
  dateList.add(new Date(t));
}