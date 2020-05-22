public <T> List<T> getQueryResults(EntityManager em, String query, 
    List<String> parameters, Class<T> clazz) {
   TypedQuery<T> query = em.createQuery(query, clazz);

   // set parameters here...

   List<T> results = query.getResultList();

   return results;
}