// You probably actually want to set the time zone of the
// formatting pattern - but you'll need to think what time zone you
// really want. We don't know enough to say. Ditto the locale...
private static final DateFormat PARSING_PATTERN = 
    new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US); 
private static final DateFormat FORMATTING_PATTERN = 
    new SimpleDateFormat("EEEE, MMMM dd, yyyy"); 

...

for (RSSItem item : feed.getAllItems()) {
    Map<String, String> datum = new HashMap<String, String>(2);
    datum.put("title", item.getTitle());

    String outputDate;
    try {
       Date date = PARSING_PATTERN.parse(item.getPubDate());
       outputDate = FORMATTING_PATTERN.format(date);
    } catch (ParseException e) {
       outputDate = "Invalid date"; // Or whatever...
    } 
    datum.put("date", outputDate);
    data.add(datum);
}