MonthDay md = MonthDay.now();

ChronoFormatter<AnnualDate> cf1 =
    ChronoFormatter.ofStyle(DisplayMode.SHORT, Locale.GERMAN, AnnualDate.chronology());
System.out.println(cf1.format(AnnualDate.from(md))); // 15.8.

ChronoFormatter<AnnualDate> cf2 =
    ChronoFormatter.ofStyle(DisplayMode.MEDIUM, Locale.GERMAN, AnnualDate.chronology());
System.out.println(cf2.format(AnnualDate.from(md))); // 15.08.

ChronoFormatter<AnnualDate> cf3 =
    ChronoFormatter.ofStyle(DisplayMode.LONG, Locale.ENGLISH, AnnualDate.chronology());
System.out.println(cf3.format(AnnualDate.from(md))); // Aug 15

ChronoFormatter<AnnualDate> cf4 =
    ChronoFormatter.ofStyle(DisplayMode.FULL, Locale.GERMAN, AnnualDate.chronology());
System.out.println(cf4.format(AnnualDate.from(md))); // 15. August

ChronoFormatter<AnnualDate> cf5 =
    ChronoFormatter.ofStyle(DisplayMode.FULL, Locale.CHINESE, AnnualDate.chronology());
System.out.println(cf5.format(AnnualDate.from(md))); // 8月15日