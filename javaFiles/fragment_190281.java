DateTime da = new DateTime("2013-09-22T12:24:23.791+02:00");
  DateTime db = new DateTime("2013-01-22T12:11:48.000+01:00");

  Period difference = new Period(db, da, PeriodType.hours());

   int hour = difference.getHours();