Properties prop = new Properties();

ObjectMapper mapper = new ObjectMapper();
// Convert my object foo into JSON format and put it into my Properties object
prop.put("myObj",  mapper.writeValueAsString(foo));

StringWriter output = new StringWriter();
// Store my properties
prop.store(output, null);

prop = new Properties();
// Load my properties
prop.load(new StringReader(output.toString()));

// Parse my object foo from the value of my new Properties object
Foo foo2 = mapper.readValue(prop.getProperty("myObj"), Foo.class);