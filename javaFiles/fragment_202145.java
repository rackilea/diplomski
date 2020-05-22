// The test string
    String str = "Sun Oct 19 01:00:00 ADT 2014";

    // Formatter for the input date
    final DateFormat inputFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
    // The parsed date
    final Date parsed = inputFormat.parse(str);

    // The output format(s). Specify the one you need
    final DateFormat outputFormat1 = new SimpleDateFormat("yyyy/MM/dd");
    final DateFormat outputFormat2 = new SimpleDateFormat("yyyy-MM-dd");

    // Print
    System.out.println(outputFormat1.format(parsed)); // -> 2014/10/21
    System.out.println(outputFormat2.format(parsed)); // -> 2014-10-21