public class Item {
    @JsonProperty("Test")
    private String test;

    @JsonProperty("Result")
    private String result;

    @JsonProperty("Credit")
    private String credit;
}

public class Root {
    @JsonProperty("Response")
    private int response;

    @JsonProperty("List")
    private List<Item> list;
}

public static void main(String[] args) {
    Root root = new Root();
    ...
    String json = new ObjectMapper().writeValueAsString(root)
}