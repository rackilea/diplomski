List<Event> eventList = new ArrayList<Event>();

    if (eventList != null) {
        List<EventDTO> eventDTOList = new ArrayList<>(EventMapper.INSTANCE.map(eventList));
        HashMap<EventFeedKey, Integer> triggersFeed = getTriggersWithCounts();
        eventList.stream().forEach(event -> {
            event.getType().getTriggers().stream().forEach(eventTypeTrigger -> {
                EventFeedKey key = new EventFeedKey(event.getId(), eventTypeTrigger.getId());
                eventTypeTrigger.setCount(triggersFeed.get(key) != null ? (Integer) triggersFeed.get(key) : 0);
            });
        });
        return eventDTOList;
    }