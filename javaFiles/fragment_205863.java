public void welcome() throws Exception {
        // Mock required services

        this.mvc.perform(get("/")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(model().attribute("user", Matchers.hasProperty("username", Matchers.equalTo("pavelkuropatin"))))
                .andExpect(model().attribute("records", Matchers.hasSize(3)))
        ;
    }