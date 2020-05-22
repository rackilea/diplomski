class MyClass 
{
    public String name;
    public Integer age;
    public Map<String, String> additionalArguments = new HashMap<>();
    public MyClass(...) {...}

    @JsonAnyGetter
    public Map<String,Object> getAdditionalProperties() {
       return additionalProperties;
    }

    @JsonAnySetter
    public void putAdditionalProperty(String name, Object value) {
        additionalProperties.put(name, value);
    }
}