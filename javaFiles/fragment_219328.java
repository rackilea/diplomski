ZoneId gmtZone = ZoneId.of("Etc/GMT");
    while (! startDateTime.isAfter(endDateTime)) {
        ZonedDateTime gmtTime = startDateTime.withZoneSameInstant(gmtZone);
        System.out.println(gmtTime.format(formatter));
        startDateTime = startDateTime.plusDays(1);
    }