public Set<Event> getForDateRange(Calendar from, Calendar to) {
    Set<Event> allEvents = getAll();

    return allEvents.stream()
            .filter(event -> event.getEventDateTime()
                    .stream()
                    .anyMatch(date -> date.after(from) && date.before(to))
            )
            .collect(Collectors.toSet());
}