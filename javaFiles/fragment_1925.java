public class POJONAME_TO_BE_REPLACED{

    // Two mandatory properties
    protected final boolean success;
    protected final String message;

    // Other flexible properties
    protected Map<String,Object> otherProps = new HashMap<String,Object>();

    @JsonCreator
    public POJONAME_TO_BE_REPLACED(@JsonProperty("success") boolean success, @JsonProperty("message") String message)
    {
        this.success = success;
        this.message = message;
    }

    public boolean getSuccess() { return success; }
    public String getMessage() { return message; }

    public Object get(String propName) {
        return otherProps.get(propName);
    }

    @JsonAnyGetter
    public Map<String,Object> any() {
        return otherProps;
    }

    @JsonAnySetter
    public void set(String propName, Object value) {
        otherProps.put(propName, value);
    }

}