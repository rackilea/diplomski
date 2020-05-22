String dateString = "17 октябрь 2014, пятница. 20:00";
    Locale rusLocale = new Locale.Builder().setLanguage("ru").setScript("Cyrl").build();
    String pattern = "dd MMMM yyyy, EEEE. HH:mm";
    try {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern, rusLocale);
        dateFormat.setTimeZone(TimeZone.getTimeZone("МСК"));  
        Date date = dateFormat.parse(dateString);   
    } catch (ParseException e) {
    ...