Todo todo = new Todo(1L, "My Third Todo");
ObjectMapper mapper = new ObjectMapper();

String todoJson = mapper.writeValueAsString(todo);

mockMvc.perform(RequestBuilder.post("/api/todos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(todoJson))
    // do whatever else you need