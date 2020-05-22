mockMvc.perform(
    get("/")
        .accept(MediaType.APPLICATION_JSON)
        .locale(Locale.GERMAN))
    .andExpect(status().isOk())
    .andDo(document("example"));