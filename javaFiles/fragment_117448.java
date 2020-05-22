ProcedureCall call = session
    .createStoredProcedureCall("post_comments");

call.registerParameter(1, 
    void.class, ParameterMode.REF_CURSOR);
call.registerParameter(2, 
    Long.class, ParameterMode.IN).bindValue(1L);

Output output = call.getOutputs().getCurrent();

if (output.isResultSet()) {
    List<Object[]> postComments = 
        ((ResultSetOutput) output).getResultList();
    assertEquals(2, postComments.size());
}