// difference between 08:00 and 16:30
LocalTime startTime = new LocalTime(8, 0);
LocalTime endTime = new LocalTime(16, 30);

Period period = new Period(startTime, endTime);
System.out.println(period); // PT8H30M
System.out.println(period.getHours()); // 8
System.out.println(period.getMinutes()); // 30

int hours = Hours.hoursBetween(startTime, endTime).getHours();
System.out.println(hours); // 8