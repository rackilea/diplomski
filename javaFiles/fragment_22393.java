LocalTime time = LocalTime.now(ZoneId.systemDefault()).truncatedTo(ChronoUnit.SECONDS);
    System.out.println("Before rounding: " + time);
    int secondsSinceLastWhole5 = time.getSecond() % 5;
    if (secondsSinceLastWhole5 >= 3) { // round up
        time = time.plusSeconds(5 - secondsSinceLastWhole5);
    } else { // round down
        time = time.minusSeconds(secondsSinceLastWhole5);
    }
    System.out.println("After rounding: " + time);