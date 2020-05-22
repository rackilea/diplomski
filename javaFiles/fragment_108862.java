private void save (City city, EntityManagerFactory emf) {
    EntityManager     em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    try {
       tx.begin();
       em.persist( city );
       tx.commit();
    } catch( RuntimeException ex ) {
       if( tx != null && tx.isActive() ) tx.rollback();
       throw ex;
    } finally {
       em.close();
    }
}