Map<String, Float> getFrequency(Map<String, ArrayList<Integer>> stringMap) {
    Map<String, Float> res = new HashMap<>();
    stringMap.entrySet().stream().forEach(e -> res.put(e.getKey()
                , e.getValue().stream().mapToInt(Integer::intValue).sum() / (float)e.getValue().size()));
    return res;
  }