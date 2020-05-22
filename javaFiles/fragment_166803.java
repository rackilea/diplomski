class Timeseries {
    private SortedMap<LocalDate, Integer> eventValues = new TreeMap<>();
    private List<Event> eventList;

    public Timeseries(List<Event> events) {
        events.forEach(e -> eventValue.put(e.getDate(), e.getValue());
        eventList=new ArrayList(events);
    }
    public List<Event> getEvents() {
        return Collections.unmodifiableList(eventList);
    }

    public Integer getValueByDate(LocalDate date) {
        Integer value = eventValues.get(date);
        if (value == null) {
            // get values before the requested date
            SortedMap<LocalDate, Integer> head = eventValues.headMap(date);
            value = head.isEmpty()
                ? 0   // none before
                : head.get(head.lastKey());  // first before
        }
        return value;
    }
}