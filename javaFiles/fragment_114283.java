String input = "pon, 17 lis 2014, 15:51:12";

TemporalField field = ChronoField.DAY_OF_WEEK;
Map<Long,String> textLookup = new HashMap<>();
textLookup.put(1L, "pon");
textLookup.put(2L, "wt");
textLookup.put(3L, "\u0347r"); // śr
textLookup.put(4L, "czw");
textLookup.put(5L, "pt");
textLookup.put(6L, "sob");
textLookup.put(7L, "niedz");

DateTimeFormatter dtf2 = 
  new DateTimeFormatterBuilder()
  .appendText(field, textLookup)
  .appendPattern(", dd MMM yyyy, HH:mm:ss")
  .toFormatter()
  .withLocale(new Locale("pl"));
LocalDateTime ldt2 = LocalDateTime.parse(input, dtf2);
System.out.print(ldt2);
// output: 2014-11-17T15:51:12