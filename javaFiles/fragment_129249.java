DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

    long longValue = -1_800_000;
    String formattedTime = Instant.ofEpochMilli(longValue)
            .atZone(ZoneId.of("Asia/Kabul"))
            .format(timeFormatter);
    System.out.println(formattedTime);