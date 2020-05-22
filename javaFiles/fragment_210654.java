Iterator<Event> eventIterator = events.iterator();

while (eventIterator.hasNext()) {
    Event event = eventIterator.next();

    Iterator<EventItem> itemIterator = items.iterator();
    while (itemIterator.hasNext()) {
        EventItem item = itemIterator.next();
        if (event.getId().equals(item.getEventId())) {
            // CLAIMED
            itemIterator.remove();
        }
    }

    // If you need to loop a second time for some reason:
    itemIterator = items.iterator();
    // ...
}