solution to issue1: find the correct Date format, google is best friend
solution to issue2: remove locale from current `DateFormat` object, only use
    DateFormat df = new DateFormat(String pattern);
    instead of
    DateFormat df = new DateFormat(String pattern, Locale aLocale);
    when convert String to Date from what return from form