days = days.stream()
    // parse to LocalDate
    .map(LocalDate::parse)
    // sort
    .sorted()
    // convert back to string
    .map(LocalDate::toString)
    // get list of String's
    .collect(Collectors.toList());