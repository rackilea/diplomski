ObjectMapper mapper = new ObjectMapper();
    SimpleModule simpleModule = new SimpleModule();
    simpleModule.addKeySerializer(Class.class, new ClassNameSerializer());
    mapper.registerModule(simpleModule);
    ...
    mapper.writeValueAsString(treeConfigMap)