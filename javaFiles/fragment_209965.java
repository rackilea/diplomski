// Fri 10:00 PM  to  Sun 10:00 PM
DayOfWeekTimeRange range = new DayOfWeekTimeRange(DayOfWeek.FRIDAY, LocalTime.of(20,0), DayOfWeek.SUNDAY, LocalTime.of(20,0));
System.out.println(range.inRange(LocalDateTime.of(2015, 11, 12, 22, 0))); // Thu Nov. 12 2015 at 10:00 PM
System.out.println(range.inRange(LocalDateTime.of(2015, 11, 14,  8, 0))); // Sat Nov. 14 2015 at  8:00 AM
System.out.println(range.inRange(LocalDateTime.of(2015, 11, 16, 15, 0))); // Mon Nov. 16 2015 at  3:00 PM

// Fri 10:00 PM  to  Mon 10:00 PM
range = new DayOfWeekTimeRange(DayOfWeek.FRIDAY, LocalTime.of(20,0), DayOfWeek.MONDAY, LocalTime.of(20,0));
System.out.println(range.inRange(LocalDateTime.of(2015, 11, 12, 22, 0))); // Thu Nov. 12 2015 at 10:00 PM
System.out.println(range.inRange(LocalDateTime.of(2015, 11, 14,  8, 0))); // Sat Nov. 14 2015 at  8:00 AM
System.out.println(range.inRange(LocalDateTime.of(2015, 11, 16, 15, 0))); // Mon Nov. 16 2015 at  3:00 PM