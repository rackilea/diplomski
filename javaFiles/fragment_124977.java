SimpleModule module = new SimpleModule();
module.addDeserializer(ThreePoints.class, new ThreePointsDeserializer());

ObjectMapper mapper = new ObjectMapper();
mapper.registerModule(module);

TypeFactory tf = mapper.getTypeFactory();
CollectionType collectionType = tf.constructCollectionType(List.class, ThreePoints.class);

List<ThreePoints> result = mapper.readValue(YOUR_DATA, collectionType);