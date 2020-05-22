DateTime startDate = DateTime.now(); // now() : since Joda Time 2.0
DateTime endDate = new DateTime(2011, 12, 25, 0, 0);

Period period = new Period(startDate, endDate, PeriodType.dayTime());

PeriodFormatter formatter = new PeriodFormatterBuilder()
        .appendDays().appendSuffix(" day ", " days ")
        .appendHours().appendSuffix(" hour ", " hours ")
        .appendMinutes().appendSuffix(" minute ", " minutes ")
        .appendSeconds().appendSuffix(" second ", " seconds ")
        .toFormatter();

System.out.println(formatter.print(period));