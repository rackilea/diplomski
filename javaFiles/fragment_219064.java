@JsonRootName("Parameters")
public class Parameters {
    private List<Parameter> parameters = new ArrayList<>();

    @JsonAnySetter
    public void setDynamicProperty(String _ignored, Map<String, String> map) {
        Parameter param = new Parameter();
        param.key = map.keySet().iterator().next();
        param.value = map.values().iterator().next();
        parameters.add(param);
    }

    public List<Parameter> getParameters() {
        return parameters;
    }
}

public class Parameter {
    public String key, value;
}