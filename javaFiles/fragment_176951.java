SimpleModule levelModule = new SimpleModule("LevelModule");
levelModule.addSerializer(Level.class, new LevelJsonSerializer());
levelModule.addDeserializer(Level.class, new LevelJsonDeserializer());

ObjectMapper objectMapper = new ObjectMapper();
objectMapper.registerModule(levelModule);