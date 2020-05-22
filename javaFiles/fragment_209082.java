List<LocalDate> sortedDates = days.stream()
    // parse to LocalDate
    .map(LocalDate::parse)
    // sort
    .sorted()
    // get list of LocalDate's
    .collect(Collectors.toList());