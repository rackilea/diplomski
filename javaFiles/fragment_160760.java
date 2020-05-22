PeriodFormatter formatter = new PeriodFormatterBuilder()
    .appendDays().appendSuffix("d ")
    .appendHours().appendSuffix("h ")
    .appendMinutes().appendSuffix("min")
    .toFormatter();

Period p = formatter.parsePeriod("2d 5h 30min");