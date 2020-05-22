StoredProcedureQuery query = entityManager
    .createStoredProcedureQuery("count_comments")
    .registerStoredProcedureParameter("postId", 
        Long.class, ParameterMode.IN)
    .registerStoredProcedureParameter("commentCount", 
        Long.class, ParameterMode.OUT)
    .setParameter("postId", 1L);

query.execute();

Long commentCount = (Long) query
    .getOutputParameterValue("commentCount");