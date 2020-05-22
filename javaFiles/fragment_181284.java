Calendar now = Calendar.getInstance();
int year = now.get(Calendar.YEAR);
int month = now.get(Calendar.MONTH) + 1; // Note: zero based!
int day = now.get(Calendar.DAY_OF_MONTH);
int hour = now.get(Calendar.HOUR_OF_DAY);
int minute = now.get(Calendar.MINUTE);
int second = now.get(Calendar.SECOND);
int millis = now.get(Calendar.MILLISECOND);

System.out.printf("%d-%02d-%02d %02d:%02d:%02d.%03d", year, month, day, hour, minute, second, millis);