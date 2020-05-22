// java.sql.Date      -> java.util.Date
    // java.sql.Timestamp -> java.util.Date
    // java.sql.Time      -> java.util.Date

    // e.g. with long value

    String target = "201405021843300400";
    DateFormat df = new SimpleDateFormat("yyyyMMddhhmmssSSSS");

    java.sql.Timestamp date = new java.sql.Timestamp(df.parse(target).getTime());

    or
    new java.sql.Timestamp(year, month, date, hour, minute, second, nano)