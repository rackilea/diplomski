String input = "30-02-1436";
ChronoFormatter<HijriCalendar> hf =
    ChronoFormatter.ofPattern(
        "dd-MM-yyyy",
        PatternType.CLDR,
        Locale.ROOT,
        HijriCalendar.family()
    ).withCalendarVariant(HijriCalendar.VARIANT_UMALQURA).with(Leniency.STRICT);
System.out.println(hf.parse(input)); // AH-1436-02-30[islamic-umalqura]
System.out.println(hf.parse(input).transform(PlainDate.axis())); // 2014-12-22