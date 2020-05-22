targetCalendar.set(2019, 11, 31);

System.out.println(currentCalendar.get(java.util.Calendar.DAY_OF_YEAR)); // Day of year since 1 Jan 2019, which is 273
System.out.println(targetCalendar.get(java.util.Calendar.DAY_OF_YEAR));  // Day of year since 1 Jan 2019, which is 365
// So your logic as per question works fine, gives 92 days (365 - 273) as result for below
System.out.println(targetCalendar.get(java.util.Calendar.DAY_OF_YEAR) - currentCalendar.get(java.util.Calendar.DAY_OF_YEAR));


// No lets change date for targetCalendar into next year
targetCalendar.set(2020, 0, 1);

System.out.println(currentCalendar.get(java.util.Calendar.DAY_OF_YEAR)); // Day of year since 1 Jan 2019, which is 273
System.out.println(targetCalendar.get(java.util.Calendar.DAY_OF_YEAR));  // Day of year since 1 Jan 2020, which is 1
// So your logic as per question works fine, gives -272 days (1 - 273) as result for below
System.out.println(targetCalendar.get(java.util.Calendar.DAY_OF_YEAR) - currentCalendar.get(java.util.Calendar.DAY_OF_YEAR));