private Stream<String> keysForLists(Map<String, Object> map) {
    // retrieve all keys which map to list values
    return map.keySet().stream()
       .filter(key -> List.class.isAssignableFrom(map.get(key).getClass()));
}

private boolean typecheck(Map<String, Object> map) {
    // check if there is really just one list value
    // and all the other values are strings
    return keysForLists(map).count() == 1
        && map.values().stream().map(o -> o.getClass())
            .filter(t -> t.equals(String.class)).count() == map.size() - 1;
}

public List<Map<String, String>> explode(Map<String, Object> map) {
    if (!typecheck(map)) {
        throw new ClassCastException(
            "Map values do not have the required types: one list plus arbitrarily many strings");
    }

    final String listKey = keysForLists(map).findFirst().get();
    final List<String> listValue = (List<String>)map.get(listKey);

    final List<Map<String, String>> result = new ArrayList<>();
    // for each list value create a new map
    listValue.forEach(value -> {
        final Map<String, String> m = new HashMap<>();
        // add the list value to the map
        m.put(listKey, value);
        // add all the other key/value pairs to the map
        map.keySet().stream().filter(k -> !k.equals(listKey))
            .forEach(k -> m.put(k, (String)map.get(k)));
        result.add(m);
    });

    return result;
}