doInJPA(entityManager -> {
    OffsetDateTimeEvent event = new OffsetDateTimeEvent();
    event.id = 1L;
    event.startDate = OffsetDateTime.of(1, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
    entityManager.persist(event);
});

doInJPA(entityManager -> {
    OffsetDateTimeEvent event = entityManager.find(OffsetDateTimeEvent.class, 1L);
    assertEquals(OffsetDateTime.of(1, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC), event.startDate);
});