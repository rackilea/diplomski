// change the minutes to 10
ZonedDateTime z2 = z.withMinute(10);
System.out.println(fmt.format(z2)); // Sun Oct 30 02:10:00 CEST 2016

// add 10 minutes
ZonedDateTime z3 = z.plusMinutes(10);
System.out.println(fmt.format(z3)); // Sun Oct 30 02:25:00 CEST 2016