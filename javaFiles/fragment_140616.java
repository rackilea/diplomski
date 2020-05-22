Map<String, Integer> myMap = new HashMap<>();
    myMap.put("a.b.c", 1);
    myMap.put("a.b.d", 2);
    myMap.put("e.f", 3);

    JSONObject output = new JSONObject();
    for (String key : myMap.keySet()) {
        String[] parts = key.split("\\.");
        Integer value = myMap.get(key);

        JSONObject currentPointer = output;
        for (int i = 0; i < parts.length; i++) {
            String part = parts[i];
            boolean isLeaf = i == parts.length - 1;
            if (currentPointer.keySet().contains(part)) {
                currentPointer = (JSONObject) currentPointer.get(part);
            } else {
                if (isLeaf) {
                    currentPointer.put(part, value);
                } else {
                    JSONObject newNode = new JSONObject();
                    currentPointer.put(part, newNode);
                    currentPointer = newNode;
                }
            }
        }
    }
    return output.toJSONString();