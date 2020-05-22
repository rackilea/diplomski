doInJPA(entityManager -> {
    List<Event> events = entityManager.createQuery(
        "select e from Event e", Event.class)
    .getResultList();
    for(Event event : events) {
        LOGGER.info("Event type: {}", event.getType());
    }
});