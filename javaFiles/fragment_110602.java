DateTimeFormatter usFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)
            .withLocale(Locale.US);
    System.out.println(date.format(usFormatter));
    DateTimeFormatter deFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)
            .withLocale(Locale.GERMANY);
    System.out.println(date.format(deFormatter));