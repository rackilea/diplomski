String jsonString_1 = "{ \"status\":true}";
String jsonString_2 = "{ \"status\":\"free\"}";

ObjectMapper objectMapper = new ObjectMapper();

MyClass myObj_1 = objectMapper.readValue(jsonString_1.getBytes(), MyClass.class);
MyClass myObj_2 = objectMapper.readValue(jsonString_2.getBytes(), MyClass.class);

System.out.println(myObj_1);
System.out.println(myObj_2);