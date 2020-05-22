class SomeCommandOriginal {
    private Long id;
    @JsonProperty("variable value")
    private JsonNode variableValue;

    //general getters and setters
}

class SomeCommand {
    private Long id;
    private String data;

    public SomeCommand(SomeCommandOriginal someCommandOriginal) {
        super();
        this.id = someCommandOriginal.id;
        this.data = someCommandOriginal.variableValue.toString();
    }

    //general getters and setters
}