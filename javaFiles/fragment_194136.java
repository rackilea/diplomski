Collections.sort (tempList, new Comparator<String>() {
  public int compare(String o1, String o2)
  {
    String sub1 = o1.substring (3);
    String sub2 = o2.substring (3);
    return sub1.compareTo (sub2);
  }
});