MyBean myBean = new MyBean(20.3);

ObjectMapper objectMapper = new ObjectMapper();
String json = objectMapper.writeValueAsString(myBean);

System.out.println(json);