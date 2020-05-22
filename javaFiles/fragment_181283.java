LocalDateTime now = LocalDateTime.now();
int year = now.getYear();
int month = now.getMonthValue();
int day = now.getDayOfMonth();
int hour = now.getHour();
int minute = now.getMinute();
int second = now.getSecond();
int millis = now.get(ChronoField.MILLI_OF_SECOND); // Note: no direct getter available.

System.out.printf("%d-%02d-%02d %02d:%02d:%02d.%03d", year, month, day, hour, minute, second, millis);