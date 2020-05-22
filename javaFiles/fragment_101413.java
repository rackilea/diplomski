public void delete(ID id) throws PersistenceException {
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    Entity row = em.find(entityClass, id);
    em.remove(row);
    em.getTransaction().commit();
}