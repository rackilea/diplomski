ObjectMapper mapper = new ObjectMapper();
String jsonInString = "{'name' : 'mkyong'}";

//JSON from file to Object
Staff obj = mapper.readValue(new File("c:\\file.json"), Staff.class);

//JSON from URL to Object
Staff obj = mapper.readValue(new URL("http://mkyong.com/api/staff.json"), Staff.class);

//JSON from String to Object
Staff obj = mapper.readValue(jsonInString, Staff.class);