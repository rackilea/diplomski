ObjectMapper xmlMapper = new XmlMapper();
List<Thing> things = new ArrayList<>();

things.add(bowl);

String xmlData = xmlMapper.writeValueAsString(things);
List<Thing> thingsFromXml = xmlMapper.readValue(xmlData, new TypeReference<List<Thing>>(){});