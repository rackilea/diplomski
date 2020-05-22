DateTimeFormatter formatter
            = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss z", Locale.US);

    ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
    String d = zdt.format(formatter);
    System.out.println(d);

    zdt = zdt.withZoneSameLocal(ZoneId.of("America/New_York"));
    String d1 = zdt.format(formatter);
    System.out.println(d1);