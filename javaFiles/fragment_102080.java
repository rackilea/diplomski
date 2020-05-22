LocalDateTime date1AsLdt = date1.toInstant()
            .atZone(ZoneId.systemDefault())
            .toLocalDateTime();
    LocalDateTime utc = OffsetDateTime.now(ZoneOffset.UTC).toLocalDateTime();
    if (date1AsLdt.isEqual(utc)){
        System.out.println("You have the correct offset!");
    }
    else
    {
        System.out.println("you do not have the correct offset!");
    }