@Test
public void index() throws Exception {
    this.mockMvc.perform(get("/api/").contextPath("/api").accept(MediaTypes.HAL_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("_links.business-cases", is(notNullValue())));
}