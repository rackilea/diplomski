UserEvent ue = new UserEvent();
    ue.setUserName("Some Username");
    ue.setUserId("userID");
    ue.setDate(new Date());
    ue.setId(123123L);
    ObjectMapper objectMapper = new ObjectMapper();
    String userEventString = objectMapper.writeValueAsString(ue);