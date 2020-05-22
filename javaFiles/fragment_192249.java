List<BeanMap> beanMaps = getItSomehow();
List<Map<String, String>> maps = new ArrayList<Map<String, String>>();

for (BeanMap beanMap : beanMaps) {
    Map<String, String> map = new HashMap<String, String>();

    for (Object o : beanMap.entrySet()) { // It's not parameterized :(
        Map.Entry<String, Object> entry = (Map.Entry<String, Object>) o;
        String key = entry.getKey();
        Object value = entry.getValue();
        map.put(key, value != null ? String.valueOf(value) : null);
    }

    maps.add(map);
}

// ...