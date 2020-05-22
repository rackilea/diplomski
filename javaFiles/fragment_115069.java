List<Map.EntrySet<String, Date>> copy = new ArrayList<Map.EntrySet<String, Date>>(treeMap.entrySet());
Collections.sort(copy, new CustomComparator());

class CustomComparator implements Comparator<Map.Entry<String,Date>> {
  public int compareTo(Map.Entry<String,Date> e1, Map.Entry<String,Date> e2) {
    // compare your dates
  }
}