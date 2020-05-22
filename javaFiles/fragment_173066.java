LocalTime s = LocalTime.of (8, 0);
LocalTime f = LocalTime.of (12, 0);

LocalTime test = LocalTime.of (10, 0);

if (test.isAfter (s) && test.isBefore (f))