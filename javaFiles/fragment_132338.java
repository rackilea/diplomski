while (threadIsActive) {
    Event firstEvent = queue.poll(queuePollTimeout, TimeUnit.MILLISECONDS);
    if (firstEvent != null) {
        // reserve enough space to fit first event, current queue capacity and
        // new events which occur while we are draining
        int drainCapacity = queue.size() * 2;
        List<Event> events = new ArrayList<>(drainCapacity);

        events.add(firstEvent);
        queue.drainTo(events);

        processEvents(events);
    }
}