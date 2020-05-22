ChronoFormatter<PlainDate> df =
    ChronoFormatter.setUp(PlainDate.axis(), Locale.ROOT)
        .addFixedInteger(PlainDate.YEAR, 4)
        .addFixedInteger(PlainDate.MONTH_AS_NUMBER, 2)
        .addFixedInteger(PlainDate.DAY_OF_MONTH, 2)
        .build();
ChronoFormatter<Moment> mf =
    ChronoFormatter.setUp(Moment.axis(), Locale.US) // US for preference of dot in decimal elements
        .addCustomized(PlainDate.COMPONENT, df)
        .addFixedInteger(PlainTime.DIGITAL_HOUR_OF_DAY, 2)
        .startOptionalSection()
        .addFixedInteger(PlainTime.MINUTE_OF_HOUR, 2)
        .startOptionalSection()
        .addFixedInteger(PlainTime.SECOND_OF_MINUTE, 2)
        .startOptionalSection()
        .addLiteral('.', ',')
        .addFraction(PlainTime.NANO_OF_SECOND, 1, 9, false)
        .endSection()
        .endSection()
        .endSection()
        .addTimezoneOffset(DisplayMode.SHORT, false, Collections.singletonList("Z"))
        .or()
        .addCustomized(PlainDate.COMPONENT, df)
        .addFixedInteger(PlainTime.DIGITAL_HOUR_OF_DAY, 2)
        .addFixedDecimal(PlainTime.DECIMAL_MINUTE)
        .addTimezoneOffset(DisplayMode.SHORT, false, Collections.singletonList("Z"))
        .or()
        .addCustomized(PlainDate.COMPONENT, df)
        .addFixedDecimal(PlainTime.DECIMAL_HOUR)
        .addTimezoneOffset(DisplayMode.SHORT, false, Collections.singletonList("Z"))
        .build();
assertThat(
    mf.parse("199412160532-0500").toString(),
    is("1994-12-16T10:32:00Z"));
assertThat(
    mf.parse("199412160532Z").toString(),
    is("1994-12-16T05:32:00Z"));
assertThat(
    mf.parse("20161231185960.123456789-0500").toString(),
    is("2016-12-31T23:59:60,123456789Z"));
assertThat(
    mf.parse("201612311859.25-0500").toString(),
    is("2016-12-31T23:59:15Z"));
assertThat(
    mf.parse("2016123118.25-0500").toString(),
    is("2016-12-31T23:15:00Z"));