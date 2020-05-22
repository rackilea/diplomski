List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>();
list.add(new AbstractMap.SimpleEntry<String, String>("foo", "bar"));

Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
  @Override
  public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
    return 0;
  }
});