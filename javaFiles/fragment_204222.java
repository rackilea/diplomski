MyJSON myJSON = new MyJSON("SUCCESS", "  ");
myJSON.addEmployeeStatus(81, "Jack");
myJSON.addEmployeeStatus(88, "Anthony");

ObjectMapper objectMapper = new ObjectMapper();
objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
String json = objectMapper.writeValueAsString(myJSON);
System.out.println(json);