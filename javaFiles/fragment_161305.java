ObjectMapper mapper = new ObjectMapper();
    String file = "src/main/resources/yourjson.json";
    JsonNode object = mapper.readTree(new File(file));
    ObjectNode child = (ObjectNode) object.path("Parent").path("Child");
    JsonNode star = child.path("*");
    child.remove("*");
    Iterator<String> startFieldNames = star.fieldNames();
    while (startFieldNames.hasNext()) {
        String startFieldName = startFieldNames.next();
        child.set(startFieldName, star.get(startFieldName));
    }
    System.out.println(mapper.writer().withDefaultPrettyPrinter().writeValueAsString(object));