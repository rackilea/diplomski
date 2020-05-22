StoredProcedureQuery query = entityManager
.createStoredProcedureQuery("count_comments")
.registerStoredProcedureParameter(
    "postId",
    Long.class,
    ParameterMode.IN
)
.registerStoredProcedureParameter(
    "commentCount",
    Long.class,
    ParameterMode.OUT
)
.setParameter("postId", 1L);

try {
    query.execute();

    Long commentCount = (Long) query
    .getOutputParameterValue("commentCount");

    assertEquals(Long.valueOf(2), commentCount);
} finally {
    query.unwrap(ProcedureOutputs.class).release();
}