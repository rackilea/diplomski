FastDateFormat parser =
    FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss", TimeZone.getTimeZone("UTC"));
Date d = parser.parse("2015-11-17 19:29:39");
System.out.println(d); // in my time zone Europe/Berlin: Tue Nov 17 20:29:39 CET 2015

FastDateFormat printer =
    FastDateFormat.getInstance(
        "MMM dd, yyyy hh:mm a",
        TimeZone.getDefault(),
        Locale.ENGLISH
    );
System.out.println(printer.format(d)); // Nov 17, 2015 08:29 PM