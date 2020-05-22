// user object mapper to parse JSON into a tree (node is the root) 
ObjectMapper mapper = new ObjectMapper();
JsonNode node = mapper.readTree(jsonString);

// use get as many times as needed by depth
// to get the value that defines the type to deserialise to
String type = node.get("metadata").get("eventName").textValue();

// convert JsonNode variable to the required type
if (type.equals("fooEvent")) {
    EventPayload<FooEvent> event = 
        mapper.convertValue(node, new TypeReference<EventPayload<FooEvent>>(){});
} else if (type.equals("barEvent")) {
    EventPayload<BarEvent> event =
        mapper.convertValue(node, new TypeReference<EventPayload<BarEvent>>(){});
}