public class SimplePojo {
    private String key ;
    private String value ;
    private int thing1 ;
    private boolean thing2;

    // tell jackson to ignore all getter methods (and public attributes as well)
    @JsonIgnore
    public String getKey() {
        return key;
    }

    // produce a map that contains the desired properties in desired hierarchy 
    @JsonAnyGetter
    public Map<String, ?> getForJson() {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> attrMap = new HashMap<>();
        attrMap.put("value", value);
        attrMap.put("thing1", thing1);  // will autobox into Integer
        attrMap.put("thing2", thing2);  // will autobox into Boolean
        map.put(key, attrMap);
        return map;
    }
}