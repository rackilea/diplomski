Locale japaneseJapan = Locale.forLanguageTag("ja-JP");

    Map<Long, String> numbers = Map.ofEntries(
            Map.entry(1L, "\u4e00"),
            Map.entry(2L, "\u4e8c"),
            Map.entry(3L, "\u4e09"),
            Map.entry(4L, "\u56db"),
            Map.entry(5L, "\u4e94"),
            Map.entry(6L, "\u516d"),
            Map.entry(7L, "\u4e03"),
            Map.entry(8L, "\u516b"),
            Map.entry(9L, "\u4e5d"),
            Map.entry(10L, "\u5341"),
            Map.entry(11L, "\u5341\u4e00"),
            Map.entry(12L, "\u5341\u4e8c"),
            Map.entry(13L, "\u5341\u4e09"),
            Map.entry(14L, "\u5341\u56db"),
            Map.entry(15L, "\u5341\u4e94"),
            Map.entry(16L, "\u5341\u516d"),
            Map.entry(17L, "\u5341\u4e03"),
            Map.entry(18L, "\u5341\u516b"),
            Map.entry(19L, "\u5341\u4e5d"),
            Map.entry(20L, "\u4e8c\u5341"),
            Map.entry(21L, "\u4e8c\u5341\u4e00"),
            Map.entry(22L, "\u4e8c\u5341\u4e8c"),
            Map.entry(23L, "\u4e8c\u5341\u4e09"),
            Map.entry(24L, "\u4e8c\u5341\u56db"),
            Map.entry(25L, "\u4e8c\u5341\u4e94"),
            Map.entry(26L, "\u4e8c\u5341\u516d"),
            Map.entry(27L, "\u4e8c\u5341\u4e03"),
            Map.entry(28L, "\u4e8c\u5341\u516b"),
            Map.entry(29L, "\u4e8c\u5341\u4e5d"),
            Map.entry(30L, "\u4e09\u4e8c\u5341"));

    DateTimeFormatter japaneseformatter = new DateTimeFormatterBuilder()
            .appendPattern("GGGG")
            .appendText(ChronoField.YEAR_OF_ERA, numbers)
            .appendLiteral('\u5e74')
            .appendText(ChronoField.MONTH_OF_YEAR, numbers)
            .appendLiteral('\u6708')
            .appendText(ChronoField.DAY_OF_MONTH, numbers)
            .appendLiteral('\u65e5')
            .toFormatter(japaneseJapan)
            .withChronology(JapaneseChronology.INSTANCE);

    String dateString = "明治二十三年十一月二十九日";
    System.out.println(dateString + " is parsed into " + LocalDate.parse(dateString, japaneseformatter));