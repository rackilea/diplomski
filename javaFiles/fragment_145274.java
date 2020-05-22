String inputDate = "2015/04/30 13:00";
    DateTimeFormatter sourceFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm", Locale.US);
    LocalDateTime local = LocalDateTime.parse(inputDate, sourceFormatter);
    // local : 2015-04-30T13:00
    //Combining this local date-time with a time-zone to create a ZonedDateTime. 
    ZonedDateTime zoned = local.atZone(ZoneId.of("Asia/Kolkata"));
    // zoned : 2015-04-30T13:00+05:30[Asia/Kolkata]
    ZonedDateTime zonedUS = zoned.withZoneSameInstant(ZoneId.of("America/Montreal"));
    // zonedUS : 2015-04-30T03:30-04:00[America/Montreal]