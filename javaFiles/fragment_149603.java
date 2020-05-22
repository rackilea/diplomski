Map<String, Object> config = new HashMap<>();
config.put(JsonSerializer.ADD_TYPE_INFO_HEADERS, false);

PersonKeySerde personKeySerde = new PersonKeySerde();
personKeySerde.configure(config, true);

PersonSerde personSerde = new PersonSerde();
personSerde.configure(config, false);

// ...
.through("person", Produced.with(personKeySerde, personSerde));