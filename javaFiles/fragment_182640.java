Locale.setDefault(Locale.UK); // So that other readers can run the example; don’t include in your production code

    DateTimeFormatter dateFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);

    String dateString1FromJDatePicker = "24 November 2019";
    String dateString2FromJDatePicker = "29 February 2020";

    LocalDate from = LocalDate.parse(dateString1FromJDatePicker, dateFormatter);
    LocalDate to = LocalDate.parse(dateString2FromJDatePicker, dateFormatter);
    long difference = ChronoUnit.DAYS.between(from, to);

    System.out.println(difference);