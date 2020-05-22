ChronoFormatter<LocalDate> cf =
    ChronoFormatter
        .ofPattern(
            "yyyyMMdd|yyyyMM|yyyy",
            PatternType.CLDR,
            Locale.ROOT,
            PlainDate.axis(TemporalType.LOCAL_DATE)
        )
        .withDefault(PlainDate.MONTH_AS_NUMBER, 1)
        .withDefault(PlainDate.DAY_OF_MONTH, 1)
        .with(Leniency.STRICT);