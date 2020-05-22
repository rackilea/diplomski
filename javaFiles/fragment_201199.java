public final class TabUtils {
    private TabUtils() {}

    private static final String TAB_CLOSED_HANDLERS_KEY = "TabUtils.CLOSED_EVENT.list";

    public static void addClosedHandler(Tab tab, EventHandler<Event> handler) {
        List<EventHandler<Event>> handlers = (List<EventHandler<Event>>) tab.getProperties().get(TAB_CLOSED_HANDLERS_KEY);
        if (handlers == null) {
            // create & store new handler list and register handler
            handlers = new ArrayList<>();
            tab.getProperties().Put(TAB_CLOSED_HANDLERS_KEY, handlers);
            tab.setOnClosed(event -> {
                for (Iterator<EventHandler<Event>> iterator = handlers.iterator(); !event.isConsumed() && iterator.hasNext();) {
                    iterator.next().handle(event);
                }
            });
        }
        handlers.add(handler);
    }

    public static void removeClosedHandler(Tab tab, EventHandler<Event> handler) {
        List<EventHandler<Event>> handlers = (List<EventHandler<Event>>) tab.getProperties().get(TAB_CLOSED_HANDLERS_KEY);
        if (handlers != null) {
            if (handlers.remove(handler) && handlers.isEmpty()) {
                // remove handler list and handler if there are no more handlers
                tab.getProperties().remove(TAB_CLOSED_HANDLERS_KEY);
                tab.setOnClosed(null);
            }
        }
    }
}