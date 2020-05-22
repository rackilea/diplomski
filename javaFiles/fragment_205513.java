//define a function that takes a list of events and produces a new event:
private NewEvent createNewEvent(List<DBEvent> events) {
    NewEvent evt = new NewEvent();
    evt.setGuiEventId(events.get(0).getGuiEventId());
    evt.setGuiEventColor(events.get(0).getGuiEventColor());
    evt.setDate1(events.get(0).getDate());
    evt.setDate2(events.get(1).getDate());

    return evt;
}