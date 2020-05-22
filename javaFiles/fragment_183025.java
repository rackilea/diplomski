int weekOfYear = 32;

LocalDate firstDay = new LocalDate().withWeekOfWeekyear(weekOfYear).withDayOfWeek(1);
LocalDate lastDay = new LocalDate().withWeekOfWeekyear(weekOfYear).withDayOfWeek(7);

System.out.println("Week of Year "+weekOfYear+"; "+firstDay.toString("d MMM")+" - "+lastDay.toString("d MMM"));