DateTimeZone.setDefault(DateTimeZone.forID("Etc/GMT"));

    DateTimeZone zone = DateTimeZone.forID("America/Los_Angeles");
    DateTimeZone gmtZone = DateTimeZone.forID("Etc/GMT");
    DateTimeFormatter formatter
            = DateTimeFormat.forPattern("EEE MMM dd HH:mm:ss zzz yyyy")
                    .withLocale(Locale.ROOT);

    String date1 = "Wed Oct 23 11:30:00 GMT 2019";
    String date2 = "Mon Nov 04 12:30:00 GMT 2019";

    LocalDateTime sDate = formatter.parseDateTime(date1)
            .withZone(zone)
            .toLocalDateTime();
    LocalDateTime eDate = formatter.parseDateTime(date2)
            .withZone(zone)
            .toLocalDateTime();
    while(eDate.isAfter(sDate) || eDate.equals(sDate)) {
        DateTime finaldate = sDate.toDateTime(zone).withZone(gmtZone);
        System.out.println(finaldate.toString(formatter));
        sDate = sDate.plusDays(1);
    }