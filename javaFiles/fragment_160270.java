@Test
public void testFooDelete() throws Exception {
    this.mockMvc.perform(MockMvcRequestBuilders
            .delete("/api/foo/11")
            .contentType(MediaType.APPLICATION_JSON))
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
}