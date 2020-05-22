final ObjectMapper mapper = new ObjectMapper();

final SimpleModule module = new SimpleModule("myModule",
        Version.unknownVersion());
module.addKeySerializer(CustomType1.class, new CustomType1Serializer());
mapper.registerModule(module);

final MapType type = mapper.getTypeFactory().constructMapType(
        Map.class, CustomType1.class, CustomType2.class);
final Map<CustomType1, CustomType2> map = new HashMap<CustomType1, CustomType2>(4);
final ObjectWriter writer = mapper.writerWithType(type);
final String json = writer.writeValueAsString(map);