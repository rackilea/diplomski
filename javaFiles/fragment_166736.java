Long commentCount = doInJPA(entityManager -> {
    try(ProcedureCall query = entityManager
            .createStoredProcedureQuery("count_comments")
            .unwrap(ProcedureCall.class)) {

        return (Long) query
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
        .setParameter("postId", 1L)
        .getOutputParameterValue("commentCount");
    }
});