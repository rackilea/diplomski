private static class Patient {
    @JsonProperty("name")
    private String name;
    @JsonProperty("age")
    private int age;

    public Patient() { }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}