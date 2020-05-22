EntityManager em;
Account findByUsername(String username){
   em.setFlushMode(FlushModeType.COMMIT);

  // perform the query
}