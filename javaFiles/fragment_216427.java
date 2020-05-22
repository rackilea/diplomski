public class Pojo {

    private String name;
    private String address;
    private Map<String, String> values;

    // Getters and setters for name and address

    @JsonAnyGetter
    public Map<String, String> getValues() {
        return values;
    }

    @JsonAnySetter
    public void setValues(Map<String, String> values) {
        this.values = values;
    }
}