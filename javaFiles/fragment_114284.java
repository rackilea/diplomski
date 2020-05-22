final Map<String, Integer> textLookup = new HashMap<String, Integer>();
  textLookup.put("pon", 1);
  textLookup.put("wt", 2);
  textLookup.put("\u0347r", 3); // śr
  textLookup.put("czw", 4);
  textLookup.put("pt", 5);
  textLookup.put("sob", 6);
  textLookup.put("niedz", 7);

  DateTimeParser parser =
    new DateTimeParser() {
    @Override
    public int estimateParsedLength() {
        return 5;
    }
    @Override
    public int parseInto(DateTimeParserBucket bucket, String text, int position) {
        for (String key : textLookup.keySet()) {
            if (text.startsWith(key, position)) {
                int val = textLookup.get(key);
                bucket.saveField(DateTimeFieldType.dayOfWeek(), val);
                return position + key.length();
            }
        }
        return ~position;
    }
  };
  DateTimeFormatter dtf =
    new DateTimeFormatterBuilder().append(parser)
    .appendPattern(", dd MMM yyyy, HH:mm:ss").toFormatter()
    .withLocale(new Locale("pl"));
  String input = "pon, 17 lis 2014, 15:51:12";
  LocalDateTime ldt = LocalDateTime.parse(input, dtf);
  System.out.println(ldt); // 2014-11-17T15:51:12.000