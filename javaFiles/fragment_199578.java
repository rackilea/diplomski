List<Name> names = projects.stream()
    .filter(p -> p.getYear() == someYear) // keep only projects of a 
                                         // given year
    .flatMap(p -> p.getNames().stream()) // get a Stream of all the
                                        // Names of all Projects
                                        // that passed the filter
    .collect(Collectors.toList());     // collect to a List