MonthDay md = MonthDay.now();

GregorianCalendar gcal =
    new GregorianCalendar(
        2000, // avoids possible leap year problems
        md.getMonthValue() - 1,
        md.getDayOfMonth()
    );

DateFormat df =
    DateFormat.getInstanceForSkeleton(
        DateFormat.ABBR_MONTH_DAY,
        Locale.forLanguageTag("en")
    );
System.out.println(df.format(gcal.getTime())); // Aug 15

DateFormat df2 =
    DateFormat.getInstanceForSkeleton(
        DateFormat.ABBR_MONTH_DAY,
        Locale.forLanguageTag("de")
    );
System.out.println(df2.format(gcal.getTime())); // 15. Aug.

DateFormat df3 =
    DateFormat.getInstanceForSkeleton(DateFormat.MONTH_DAY, Locale.forLanguageTag("zh"));
System.out.println(df3.format(gcal.getTime())); // 8月15日