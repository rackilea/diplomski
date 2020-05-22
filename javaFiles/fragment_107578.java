EntityManager em = EMFService.getFactory().createEntityManager();
EntityTransaction tx = em.getTransaction();
tx.begin();

try {
    User fromContact = User.find(fromId, em);

    Event event = Event.builder()
            /* attributes initialization */
            .build();
    em.persist(event);

    User toUser = User.find(toId, em);
    event.addAddressee(toUser, Response.UNDEFINED);

    tx.commit();
} finally {
    if (tx.isActive()) tx.rollback();
    em.close();
}