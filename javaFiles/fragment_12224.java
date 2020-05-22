this.mockMvc.perform(post("/j_spring_security_check")
            .param("j_username", "fred")
            .param("j_password", "fredspassword"))
            .andExpect(status().isMovedTemporarily())
            .andDo(new ResultHandler() {
                @Override
                public void handle(MvcResult result) throws Exception {
                    sessionHolder.setSession(new SessionWrapper(result.getRequest().getSession()));
                }
            });