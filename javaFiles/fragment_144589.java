// wrapper to extract result from the response
AssignmentResult result = new AssignmentResult();

// perform request 
mockMvc.perform(
        get("/myApiEndpoint")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
        )
.andExpect(status().isOk())
    .andExpect(jsonPath("$object.parent.id", is(parent.getId())))
    .andDo(assignTo("$object.id", result)); // (**)

Integer objectIdFromResult = (Integer)result.getValue();    // (++)