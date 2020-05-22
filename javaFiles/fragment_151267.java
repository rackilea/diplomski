@Test
    public void testGrantAuthorizationForUser() throws Exception{
        Optional<UserEntity> userEntityAuthz = userRepository.findOneByUsername(USER_NAME);
        Set<String> expectedAuthzList = (LinkedHashSet)userEntityAuthz.get().getAuthorizations();

        List<String> grantList = new ArrayList<>();
        grantList.add("ABC");
        grantList.add("DEF");
        grantList.add("GHI");
        grantList.add("JKL");
        grantList.add("MNO");
        grantList.add("PQR");
        grantList.add("STU");
        grantList.add("VWX");
        grantList.add("YZA");

        JSONArray json = new JSONArray();

        MvcResult grantAuthzResult = mockMvc.perform(MockMvcRequestBuilders.post(USER_URL,USER_ID)
                .contentType(contentType)
                .content(json.toString()))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }