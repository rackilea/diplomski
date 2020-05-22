class Alerts {

    @JsonAdapter(value = LowercaseMapTypeAdapterFactory.class)
    private Map<String, String> labels;

    private String otherInfo;

    // getters, setters, toString
}