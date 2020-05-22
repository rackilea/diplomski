doInJPA(entityManager -> {
    LocalDateEvent event = new LocalDateEvent();
    event.id = 1L;
    event.startDate = LocalDate.of(1, 1, 1);
    entityManager.persist(event);
});

doInJPA(entityManager -> {
    LocalDateEvent event = entityManager.find(LocalDateEvent.class, 1L);
    assertEquals(LocalDate.of(1, 1, 1), event.startDate);
});