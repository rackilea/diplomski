private class SimpleChain implements EventDispatchChain {

    private Deque<EventDispatcher> dispatchers = new LinkedList<>();

    @Override
    public EventDispatchChain append(EventDispatcher eventDispatcher) {
        dispatchers.addLast(eventDispatcher);
        return this;
    }

    @Override
    public EventDispatchChain prepend(EventDispatcher eventDispatcher) {
        dispatchers.addFirst(eventDispatcher);
        return this;
    }

    @Override
    public Event dispatchEvent(Event event) {
        if (dispatchers.peekFirst() != null) {
            Event result = dispatchers.removeFirst().dispatchEvent(event, this);
            if (result != null) {
                return result;
            } else {
                event.consume();
                return event;
            }
        } else {
            return event;
        }
    }
}