DateTimeFormatter format = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss");
    ZonedDateTime t1 = LocalDateTime.parse("2013-05-03 07:00:00", format)
            .atZone(ZoneId.systemDefault());
    ZonedDateTime t2 = LocalDateTime.parse("2013-05-03 23:30:00", format)
            .atZone(ZoneId.systemDefault());

    System.out.println("1) Days Since Epoch: " + ChronoUnit.DAYS.between(Instant.EPOCH, t1));
    System.out.println("2) Days Since Epoch: " + ChronoUnit.DAYS.between(Instant.EPOCH, t2));