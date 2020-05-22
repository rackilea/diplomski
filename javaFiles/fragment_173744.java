DateTimeFormatter originalFormatter
            = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss.SS");
    DateTimeFormatter newFormatter
            = DateTimeFormatter.ofPattern("dd MMM uuuu HH:mm z", Locale.ENGLISH);
    String originalTimestamp = "2018-01-01 18:20:23.11";
    String differentFormat = LocalDateTime.parse(originalTimestamp, originalFormatter)
            .atZone(ZoneId.of("Etc/UTC"))
            .format(newFormatter);
    System.out.println(differentFormat);