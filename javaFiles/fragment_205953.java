public class ResponseEntity {

    private String result;
    private final Map<String, Object> otherFields = new HashMap<>();

    public String getResult() {
        return result;
    }

    @JsonAnyGetter
    public Map<String, Object> getOtherFields() {
        return otherFields;
    }

    public void addField(String field, Object value) {
        otherFields.put(field, value);
    }
}