List<EventHandler<Event>> closedEventHandlers = new ArrayList<>();
tab.setOnClosed(event -> {
    for (Iterator<EventHandler<Event>> iterator = closedEventHandlers.iterator(); !event.isConsumed() && iterator.hasNext();) {
        iterator.next().handle(event);
    }
});