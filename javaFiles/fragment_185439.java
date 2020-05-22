class EventDispatcher {

    static Map<Event, Collection<Listener>> map;

    static void registerListener(Collection<Event> eventTypes, Listener listener) {

        eventTypes.forEach(et -> map.put(et, listener));
    }

    static void dispatch(SomeEvent event) {

        map.get(SomeEvent.getClass()).forEach(l -> l.trigger(event));
    }

    static void deregisterListener(Listener listener) {

        while (map.values().remove(listener));
    }
}