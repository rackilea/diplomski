public static class MyClass {
    private String defaultReference;

    @JsonProperty(value = "default_reference")
    public void setDefaultReference(String defaultReference) {
        this.defaultReference = defaultReference;
    }

    @JsonProperty(value = "defaultReference")
    public String getDefaultReference() {
        return defaultReference;
    }

    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        MyClass instance = objectMapper.readValue("{\"default_reference\": \"value\"}", MyClass.class);
        objectMapper.writeValue(System.out, instance);
        // Output: {"defaultReference":"value"}
    }
}