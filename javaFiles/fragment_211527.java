Map<String, List<EventDto>> map = 
    events.getItems()
          .stream()
          .collect(Collectors.groupingBy(Event::getStatus, 
                                         Collectors.mapping(this::convertFromEventToEventDto,
                                                            Collectors.toList())));