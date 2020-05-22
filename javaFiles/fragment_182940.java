long millisPerDay = TimeUnit.DAYS.toMillis(1);
Map<Long, List<Date>> datesByDay = new HashMap<>();
for (Date date : dates) {
    long day = date.getTime() / millisPerDay;
    List<Dates> dayDates = datesByDay.get(day);
    if (dayDates == null) {
        dayDates = new ArrayList<>();
        datesByDay.put(day, dayDates);
    }
    dayDates.add(date);
}