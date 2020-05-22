Map<Integer, List<String>> valuesMap = new HashMap<>();
    for (String key : map.keySet()) {
        Integer val = map.get(key);
        if (valuesMap.get(val) == null) {
            List<String> values = new ArrayList<>();
            values.add(key);
            valuesMap.put(val, values);
        } else {
            valuesMap.get(val).add(key);
        }
    }