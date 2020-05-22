String inputDate = "09-OCT-2017";
DateTimeFormatter inputFormatter = new DateTimeFormatterBuilder()
    .parseCaseInsensitive()
    // use "dd" for day of month and "yyyy" for year
    .appendPattern("dd-MMM-yyyy")
    .toFormatter(Locale.ENGLISH);
LocalDate localDate = LocalDate.parse(inputDate, inputFormatter);

// use "dd" for day of month and "yyyy" for year
DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
String formattedString = localDate.format(outputFormatter);
System.out.println(formattedString); // 20171009