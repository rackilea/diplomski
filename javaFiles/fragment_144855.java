String time = "3:45-PM";

DateTimeFormatter formatter = DateTimeFormat.forPattern("KK:mm-a")
        .withZone(DateTimeZone.forID("America/New_York"));

DateTime dt = formatter.parseDateTime(time)
        .withDate(LocalDate.now());

System.out.println(dt);

System.out.println(dt.withZone(DateTimeZone.UTC));