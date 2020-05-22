public class Claim {
    Map<String, Object> properties = new HashMap<>();

    public Claim() {
        // may be populated from instance variables
        Map<String, String> person = new HashMap<>();
        person.put("name", "Sam");
        person.put("surname", "ngonma");
        properties.put("person", person);
        Map<String, String> car = new HashMap<>();
        car.put("make", "Toyota");
        car.put("model", "yaris");
        properties.put("car", car);
    }

    // nullify map values based on provided array
    public void filterProperties (String[] nullifyValues) {
        filterProperties(properties, nullifyValues);
    }

    // nullify map values of provided map based on provided array
    @SuppressWarnings("unchecked")
    private void filterProperties (Map<String, Object> properties, String[] nullifyValues) {
        // iterate all String-typed values
        // if value found in array arg, nullify it
        // (we iterate on keys so that we can put a new value)
        properties.keySet().stream()
            .filter(key -> properties.get(key) instanceof String)
            .filter(key -> Arrays.asList(nullifyValues).contains(properties.get(key)))
            .forEach(key -> properties.put(key, null));
        // iterate all Map-typed values
        // call this method on value
        properties.values().stream()
            .filter(value -> value instanceof Map)
            .forEach(value -> filterProperties((Map<String, Object>)value, nullifyValues));
    }

    // provide jackson with Map of all properties
    @JsonAnyGetter
    public Map<String, Object> getProperties() {
        return properties;
    }
}