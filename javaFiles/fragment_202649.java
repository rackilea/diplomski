ObjectMapper mapper = new ObjectMapper();
SimpleModule module = new SimpleModule();
module.addDeserializer(Team.class, new TeamDeserializer());
mapper.registerModule(module);

Team value = mapper.readValue(json, Team.class);