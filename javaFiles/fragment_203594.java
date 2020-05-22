DateTime dt = new DateTime()
    .withWeekyear(year)
    .withWeekOfWeekyear(weekOfYear)
    .withDayOfWeek(weekDay);
DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyMMdd");
System.out.println(dateTimeFormatter.print(dt));