EntityManager em;
Account findByUsername(String username){
  Query query = em.createQuery(..); 
  query.setFlushMode(FlushModeType.COMMIT);

  // perform the query
}