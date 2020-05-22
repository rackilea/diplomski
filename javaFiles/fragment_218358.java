DateTimeFormatter userInputFormatter = DateTimeFormatter.ofPattern("dd/MM/uuuu HH:mm");
    String userInput = "25/04/2019 13:10";
    ZoneId arrivalTimeZone = ZoneId.of("Europe/Istanbul");

    // Parse into a LocalDateTime
    LocalDateTime arrivalTimeLocal = LocalDateTime.parse(userInput, userInputFormatter);
    System.out.println("Arrival time:                           " + arrivalTimeLocal);