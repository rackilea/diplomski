public class ExampleConfiguration extends Configuration {

    private String name;

    @JsonProperty
    public String getName() {
        return this.name;
    }

    @JsonProperty
    public void setName(String name) {
        this.name = name;
    }
}