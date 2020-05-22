// 1 hour before DST starts
DateTime d = new DateTime(2018, 2, 21, 15, 0, 0, 0, new FakeTimeZone("America/Los_Angeles"));

// This prints 2018-02-21T15:00:00.000-08:00 (standard offset)
System.out.println(d);

// 1 hour later, DST is in effect, it prints 2018-02-21T17:00:00.000-07:00
System.out.println(d.plusHours(1));