public class ServiceEventRepository {
    private Map<String, SortedSet<ServiceEvent>> storage = new HashMap<>();

    public void addEvent(String service, ServiceEvent event) {
        SortedSet<ServiceEvent> events = storage.get(service);
        if (events == null) {
            events = new TreeSet<ServiceEvent>(new ServiceEventComparator());
            storage.put(service, events);
        }
        events.add(event);
    }
}