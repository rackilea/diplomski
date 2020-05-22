@Test
public void testTest() throws Exception {
    MvcResult result = mockMvc.perform(post("/rest/tasks/test"))
        .andExpect(request().asyncStarted())
        .andReturn();
    // Trigger a timeout on the request
    MockAsyncContext ctx = (MockAsyncContext) result.getRequest().getAsyncContext();
    for (AsyncListener listener : ctx.getListeners()) {
        listener.onTimeout(null);
    }
    mockMvc.perform(asyncDispatch(result))
        .andExpect(status().isOk())
        ;
}