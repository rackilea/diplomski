LocalDate ld = LocalDate.of(2017, 8, 18); // Friday as original date

System.out.println(
    ld.with(DayOfWeek.SUNDAY)); // 2017-08-20 (2 days later according to ISO)

// Now let's again set the date to Sunday, but this time in a localized way...
// the method dayOfWeek() uses localized numbering (Sunday = 1 in US and = 7 in France)

System.out.println(ld.with(WeekFields.of(Locale.US).dayOfWeek(), 1L)); // 2017-08-13
System.out.println(ld.with(WeekFields.of(Locale.FRANCE).dayOfWeek(), 7L)); // 2017-08-20