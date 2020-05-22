{ 
    List<Event> events = services.getEvents();
    for(Event event : events){
        map.put(event.getId() + "", event);
    } 
}