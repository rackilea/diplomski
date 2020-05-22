DateTimeFormatter format = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss");
    OffsetDateTime t1 = LocalDateTime.parse("2013-05-03 07:00:00", format)
            .atOffset(ZoneOffset.UTC);
    OffsetDateTime t2 = LocalDateTime.parse("2013-05-03 23:30:00", format)
            .atOffset(ZoneOffset.UTC);

    System.out.println("1) Days Since Epoch: " + ChronoUnit.DAYS.between(Instant.EPOCH, t1));
    System.out.println("2) Days Since Epoch: " + ChronoUnit.DAYS.between(Instant.EPOCH, t2));