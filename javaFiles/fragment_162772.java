JsonNodeFactory factory = JsonNodeFactory.instance;
ObjectNode root = factory.objectNode();
root.put("Response", 200);
ArrayNode list = factory.arrayNode();
list.add(...);
...
root.set("List", list);