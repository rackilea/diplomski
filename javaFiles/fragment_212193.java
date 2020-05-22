LocalDate date = LocalDate.now();
LocalDate endOfMonth = date.withDayOfMonth(date.lengthOfMonth());

date = date.withDayOfMonth(1);
System.out.println(date);
date = date.with(ChronoField.DAY_OF_WEEK, DayOfWeek.SATURDAY.getValue());

int count = 0;
while (date.isEqual(endOfMonth) || date.isBefore(endOfMonth)) {
    count++;
    date = date.plusDays(7);
}

System.out.println("You have " + count + " Saturdays");