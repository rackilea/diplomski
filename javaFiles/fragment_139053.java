class Data {
    @JsonDeserialize(using = InstantiateOnNullDeserializer.class)
    protected final Value value;


    @JsonProperty("value")
    public Value getValue() {
        return value;
    }



    @JsonCreator
    public Data(Value value) {
        this.value = value;
    }
}