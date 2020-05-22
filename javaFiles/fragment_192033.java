@Transactional
public Subject createNewSubjectByName(String name) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    Subject subject = new Subject();
    subject.setName(name);
    entityManager.getTransaction().begin();
    entityManager.persist(subject);
    entityManager.flush();
    entityManager.getTransaction().commit();
    entityManager.close();
    return subject;
}