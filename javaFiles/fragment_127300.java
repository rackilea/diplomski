public class MyError {

    @JsonProperty("code")
    private String code;

    @JsonProperty("description")
    private String description;

    private List<String> params;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getParams() {
        return params;
    }

    @JsonProperty("params")
    private void setParams(JsonNode params) {
        if (params.isArray()) {
            this.params = new ArrayList<>();
            for(JsonNode child : params) {
                this.params.add(child.asText());
            }
        }
    }
}