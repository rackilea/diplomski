ObjectMapper mapper = new ObjectMapper();
    //Add pretty print indentation
    mapper.enable(SerializationFeature.INDENT_OUTPUT);

    //When serializing we have to wrap it in a try/catch signature
    try {
        mapper.writeValue(Gdx.files.local("creature.json").file(), creature);
    } catch (IOException e) {
        e.printStackTrace();
    }

    //To map it back to a object we do the same
    Creature jsonCreature = null;
    try {
        jsonCreature = mapper.readValue(Gdx.files.local("creature.json").readString(), Creature.class);
    } catch (IOException e) {
        e.printStackTrace();
    }

    //Jackson also has control over what you want to serialize
    mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    //Or with annotation in front of the class
    @JsonIgnoreProperties({"nameOfProperty", "anotherProperty"})