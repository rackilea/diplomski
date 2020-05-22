public boolean delete(T entity) {

    if (entity == null) {
        throw new IllegalArgumentException();
    }

    EntityManager em = entityManager();
    EntityTransaction tx = em.getTransaction();

    try {
        tx.begin();
        em.refresh(entity);
        em.remove(entity);
        tx.commit();
        return true;
    } catch (EntityNotFoundException ex) {
        tx.rollback();
        return false;
    } catch (RuntimeException ex) {
        tx.rollback();
        throw ex;
    } finally {
        em.close();
    }

}