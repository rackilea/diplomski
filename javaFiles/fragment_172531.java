int month = 9;
    int day = 17;
    int year = 2013;
    int hour= 0;
    int minute =0;
    int second =0;
    int millisecond = 0;

    DateTime dt1 = new DateTime(); //now
    DateTime dt2 = new DateTime(year, month, day, hour, minute, second, millisecond);

    //assuming dt1 is before dt2:
    Period period = new Period(dt1, dt2, PeriodType.dayTime());

   /*
    periodType.dayTime()):
    Gets a type that defines all standard fields from days downwards.

       days
       hours
       minutes
       seconds
       milliseconds 
   */

    PeriodFormatter periodFormatter = new PeriodFormatterBuilder()
            .printZeroAlways()
            .minimumPrintedDigits(2)
            .appendDays().appendSuffix("days ")
            .appendHours().appendSuffix("hours ")
            .appendMinutes().appendSuffix("minutes ")
            .appendSeconds().appendSuffix("seconds ");
            .toFormatter(); 

    System.out.println(periodFormatter.print(period));