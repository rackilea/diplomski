public class Tool {

    @JsonProperty("name")
    private String name;

    @JsonProperty("parameters")
    private List<String> parameters;

    public Tool() {
    }

    public Tool(String name, List<String> parameters) {
        this.name = name;
        this.parameters = parameters;
    }       
}