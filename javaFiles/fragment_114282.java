String input = "pon, 17 lis 2014, 15:51:12";

DateTimeFormatter dtf1 = 
  DateTimeFormatter.ofPattern("EEE, dd MMM yyyy, HH:mm:ss", new Locale("pl"));
LocalDateTime ldt1 = LocalDateTime.parse(input, dtf1);
System.out.print(ldt1);
// error message:
// java.time.format.DateTimeParseException:
// Text 'pon, 17 lis 2014, 15:51:12' could not be parsed at index 0