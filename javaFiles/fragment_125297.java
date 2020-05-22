public static class Test {

    @JsonIgnore
    Optional<String> data;

    @JsonRawValue
    public String getDataValue() {
        return data.orElse(null);
    }

    public Optional<String> getData() {
        return data;
    }

    public void setData(final Optional<String> data) {
        this.data = data;
    }
}

public static void main(final String[] args) throws JsonProcessingException {
    final ObjectMapper om = new ObjectMapper();

    final Test data = new Test();
    data.data = Optional.of("Hello World");

    final String value = om.writeValueAsString(data);
    System.out.println(value);
}