public Map<Integer, Integer> combine(List<Map<Integer, Integer>> maps) {
    Map<Integer, Integer> result = new HashMap<Integer, Integer>();
    for (Map<Integer, Integer> map : maps) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int newValue = entry.getValue();
            Integer existingValue = result.get(entry.getKey());
            if (existingValue != null) {
                 newValue = newValue + existingValue;
            }
            result.put(entry.getKey(),  newValue);
        }
    }
    return result;
}