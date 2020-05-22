RequestVO requestVO = new RequestVO(null);

ObjectMapper mapper = new ObjectMapper();
try {
    String requestString = mapper.writeValueAsString(requestVO);
    System.out.println(requestString);
} catch (JsonProcessingException e) {
    e.printStackTrace();
}