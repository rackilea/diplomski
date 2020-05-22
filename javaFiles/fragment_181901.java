List<Map.Entry<String, Integer>> entries = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
  public int compare(
      Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
    return entry1.getValue().compareTo(entry2.getValue());
  }
});