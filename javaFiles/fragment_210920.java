public class RefactorMe {
  class Event<K> {
    public K getNewObject() {
      return null;
    }
  }

  private static Map<Class<?>, List<Event<?>>> eventLists = new HashMap<>();

  public static <E> List<Event<E>> getEventList(Class<E> clazz) {
    return (List) eventLists.get(clazz);
  }

  public static <E extends Event<E>> void addEvent(Event<E> pEvent) {
    Class<E> key = (Class<E>) pEvent.getNewObject().getClass();
    List<Event<?>> events = eventLists.get(key);
    if (events == null) {
      events = new ArrayList<>();
      eventLists.put(key, events);
    }
    events.add(pEvent);
  }
}