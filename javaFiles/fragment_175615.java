LocalDateTime startDateTime = LocalDateTime.of(2017, Month.DECEMBER, 1, 17, 0);
    LocalDateTime endDateTime = LocalDateTime.of(2017, Month.DECEMBER, 2, 17, 1);
    LocalTime timeToTest = LocalTime.of(11, 34);

    // Does the timeToTest occur some time between startDateTime and endDateTime?
    LocalDateTime candidateDateTime = startDateTime.with(timeToTest);
    if (candidateDateTime.isBefore(startDateTime)) {
        // too early; try next day
        candidateDateTime = candidateDateTime.plusDays(1);
    }
    if (candidateDateTime.isAfter(endDateTime)) {
        System.out.println("No, " + timeToTest + " does not occur between " + startDateTime + " and " + endDateTime);
    } else {
        System.out.println("Yes, the time occurs at " + candidateDateTime);
    }