EntityManager em = EMF.getEntityManager();
EntityTransaction et = em.getTransaction();
try {
  MyEntity my = new MyEntity();
  et.begin();
  try {
    em.persist(my);
    et.commit();
  } catch (Exception ex) { 
    if (et.isActive())
      et.rollback();
  }
} finally {
  em.close();
}