final String json = new ObjectMapper().writeValueAsString(emp);
service
    .path("rest")
    .path("emp")
    .queryParam("filter", json)
    .accept(emp, MediaType.TEXT_PLAIN)
    .get(String.class)