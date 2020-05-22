public class Something {
    @JsonProperty
    private List<Field> fields;
}

public class Field {
    @JsonProperty
    private String name;

    @JsonProperty
    private List<?> values;
}