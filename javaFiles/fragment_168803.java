ChronoFormatter<HijriCalendar> f1 =
        ChronoFormatter.setUp(HijriCalendar.family(), Locale.ENGLISH)
            .addEnglishOrdinal(HijriCalendar.WEEKDAY_IN_MONTH)
            .addPattern(" EEEE 'in' MMMM", PatternType.CLDR)
            .build();
    assertThat(f1.format(hijri), is("1st Sunday in Ramadan"));

    ChronoFormatter<HijriCalendar> f2 =
        ChronoFormatter.ofPattern(
            "F. EEEE 'im' MMMM", 
            PatternType.CLDR, 
            Locale.GERMAN, 
            HijriCalendar.family());
    assertThat(f2.format(hijri), is("1. Sonntag im Ramadan"));