@Data
public class POJO {
    private Map<String, List<OpenOrderPOJO>> unknownSubCategories;

    @JsonAnySetter
    public void setMap(String key, List<OpenOrderPOJO> value) {
        if (unknownSubCategories == null) {
            unknownSubCategories = new LinkedHashMap<>();
        }
        unknownSubCategories.put(key, value);
    }
}