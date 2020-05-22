class Bar {
    @JsonProperty
    private Foo foo;

    // setter/getter
}

public List<Bar> getBars() {
    return java.util.Arrays.asList(restTemplate.getForObject(buildUri("/foos.json"),
            Bar[].class));
}