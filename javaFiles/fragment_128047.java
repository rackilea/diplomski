Map<String, Object> map = new HashMap<String, Object>();
...
for (Map.Entry<String, Object> entry : map.entrySet()) {
    if (entry.getValue() instanceof String) {
        // Do something with entry.getKey() and entry.getValue()
    } else if (entry.getValue() instanceof Class) {
        // Do something else with entry.getKey() and entry.getValue()
    } else {
        throw new IllegalStateException("Expecting either String or Class as entry value");
    }
}