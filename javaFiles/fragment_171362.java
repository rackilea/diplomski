ObjectMapper mapper = new ObjectMapper();
mapper.setSerializationInclusion(Include.NON_NULL);

TestBean bean = new TestBean();
bean.setEmail("test@test.com");
bean.setOtherField(null);

try {
    String jsonContent = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(bean);
    System.out.println("jsonContent = " + jsonContent);
} catch (JsonProcessingException e) {
    e.printStackTrace();
}