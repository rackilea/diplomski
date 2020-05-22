Principal principal = new Principal() {
        @Override
        public String getName() {
            return "TEST_PRINCIPAL";
        }
    };
getMockMvc().perform(get("http://your-url.com").principal(principal))
        .andExpect(status().isOk()));