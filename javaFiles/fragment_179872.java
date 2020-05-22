ObjectMapper om = new ObjectMapper();
om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

// your example JSON
String json = "{\"id\":23,\"name\":\"test\",\"type\":\"person\",\"_data\":"
+ "{\"address\":23432}}";
Wrapper<Person> wrapped = om.readValue(
    json, new TypeReference<Wrapper<Person>>() {}
);

// printing class/hashCode of the resolved generic type
System.out.println(wrapped.data);
// casting as Person and printing actual property
System.out.println(((Person)wrapped.data).address);