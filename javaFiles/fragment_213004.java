LocalDateTime start = LocalDateTime.now();
start = start.withDayOfMonth(26).withHour(17).withMinute(42).withSecond(0).withNano(0);
LocalDateTime end = start.plusDays(2);

LocalDateTime check = LocalDateTime.now();

System.out.println(check + " is within range = " + isBetween(check, start, end));
check = start;
System.out.println(check + " is within range = " + isBetween(check, start, end));
check = end;
System.out.println(check + " is within range = " + isBetween(check, start, end));
check = start.plusDays(1);
System.out.println(check + " is within range = " + isBetween(check, start, end));
check = end.plusMinutes(1);
System.out.println(check + " is within range = " + isBetween(check, start, end));