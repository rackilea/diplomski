public static class MyClass {
    @JsonProperty
    private String name = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonSetter
    public void setName2(String name2) {
        setName(name2);
    }
}