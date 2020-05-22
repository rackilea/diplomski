Map<Long, String> monthTexts = new HashMap<>(16);
    monthTexts.put(1L, "Jan.");
    monthTexts.put(2L, "Feb.");
    monthTexts.put(3L, "Mär.");
    monthTexts.put(4L, "Apr.");
    monthTexts.put(5L, "Mai");
    monthTexts.put(6L, "Jun.");
    monthTexts.put(7L, "Jul.");
    monthTexts.put(8L, "Aug.");
    monthTexts.put(9L, "Sep.");
    monthTexts.put(10L, "Okt");
    monthTexts.put(11L, "Nov.");
    monthTexts.put(12L, "Dez.");
    DateTimeFormatter monthFormatter = new DateTimeFormatterBuilder()
            .appendText(ChronoField.MONTH_OF_YEAR, monthTexts)
            .appendPattern(" u")
            .toFormatter();

    String dateString = from.format(monthFormatter) + " – " + to.format(monthFormatter);

    System.out.println(dateString);