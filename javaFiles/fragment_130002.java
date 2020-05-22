class FieldDefinitions {

    public static final String FIELDS = "Fields";
    public static final String DESCRIPTION = "Description";

    @JsonProperty(value = FIELDS, required = true)
    private FieldDetails fields;

    @JsonProperty(value = DESCRIPTION, required = true)
    private Map<String, Description> descriptions;

    // getters, setters, toString
}