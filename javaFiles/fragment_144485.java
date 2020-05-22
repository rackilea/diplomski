DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss");
    String existingTime = "2017-12-09 17:00:00";
    OffsetDateTime existingDateTime = LocalDateTime.parse(existingTime, formatter)
            .atOffset(ZoneOffset.UTC);
    System.out.println("UTC existingDateTime: " + existingDateTime.format(formatter));
    System.out.println("Pyongyang existingDateTime: " 
            + existingDateTime.atZoneSameInstant(ZoneId.of("Asia/Pyongyang"))
                    .format(formatter));
    System.out.println("Singapore existingDateTime: " 
            + existingDateTime.atZoneSameInstant(ZoneId.of("Asia/Singapore"))
                    .format(formatter));