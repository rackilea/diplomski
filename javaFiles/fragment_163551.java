MockHttpSession session = new MockHttpSession();
    session.putValue("TTL", Instant.now().minusSeconds(60).toEpochMilli());

mockMvc.perform(get("/rest/message").session(session))
        .andExpect(status().isOk());

assertThat((Long) session.getAttribute("TTL"), Matchers.greaterThan(Instant.now().toEpochMilli()));