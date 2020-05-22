ObjectMapper mapper = new ObjectMapper();
Staff obj = new Staff();

//Object to JSON in file
mapper.writeValue(new File("c:\\file.json"), obj);

//Object to JSON in String
String jsonInString = mapper.writeValueAsString(obj);