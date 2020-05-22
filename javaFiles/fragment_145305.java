LocalDate expiration = set.getObject("expiry", LocalDate.class);
    LocalDate today = LocalDate.now(ZoneId.of("Europe/London"));
    if (today.isBefore(expiration)) {
        System.out.println("Fine");
    } else  {
        System.out.println("Expired");
    }