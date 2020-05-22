ChronoFormatter<LocalDate> cf =
ChronoFormatter
    .ofPattern(
        "yyyy[MM]",
        PatternType.THREETEN,
        Locale.ROOT,
        PlainDate.axis(TemporalType.LOCAL_DATE)
    )
    .withDefault(PlainDate.MONTH_AS_NUMBER, 1)
    .withDefault(PlainDate.DAY_OF_MONTH, 1)
    .with(Leniency.STRICT);
System.out.println(cf.parse("201411")); 
// java.text.ParseException: Positive sign must be present for big number.