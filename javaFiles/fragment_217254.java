Map<Location, EventStatistics> result = 
    events.stream()
          .collect(Collectors.groupingBy(Event::getLocation,
                                         Collectors.collectingAndThen(
                                             Collectors.toList(), 
                                             EventStatistics::new)));