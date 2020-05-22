public List<IEvent> getEventsByDateRange(DateTime minStartTime, DateTime minEndTime)
{
    List<IEvent> returnedEvents = new ArrayList<IEvent>();
    returnedEvents.add(new GoogleEvent());
    return returnedEvents;
}