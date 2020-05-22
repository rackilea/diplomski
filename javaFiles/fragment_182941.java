long millisPerDay = TimeUnit.DAYS.toMillis(1);
Multimap<Long, Date> datesByDay = ArrayListMultimap.create();
for (Date date : dates) {
    long day = date.getTime() / millisPerDay;
    datesByDay.put(day, date);
}