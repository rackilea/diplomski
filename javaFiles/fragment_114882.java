Map<Pattern, DateFormat> dateFormatPatterns = new HashMap<Pattern, DateFormat>();
dateFormatPatterns.put(Pattern.compile("\\d{1,2}:\\d{2}"), new SimpleDateFormat("H:m"));
dateFormatPatterns.put(Pattern.compile("\\d{1,3}\\.\\d{3}"), new SimpleDateFormat("s.S"));
dateFormatPatterns.put(Pattern.compile("\\d{1,2}\\.\\d{2} s"), new SimpleDateFormat("s.S 's'"));

String[] strings = { "00:43", "113.046", "21.55 s" };
DateFormat finalFormat = new SimpleDateFormat("HH:mm:ss");

for (String string : strings) {
    for (Pattern pattern : dateFormatPatterns.keySet()) {
        if (pattern.matcher(string).matches()) {
            Date date = dateFormatPatterns.get(pattern).parse(string);
            String formattedTime = finalFormat.format(date);
            System.out.println(formattedTime);
            break;
        }
    }
}