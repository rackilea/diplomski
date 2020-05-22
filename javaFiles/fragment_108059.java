MvcResult result = mvc.perform(post("/api/users/new")
  .content(TestHelpers.convertToJson(registroMock))
  .contentType(TestHelpers.getJsonMediaType()))
  .andReturn();

mvc.perform(asyncDispatch(result))
   .andExpect(status().isCreated());