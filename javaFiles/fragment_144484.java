final Map<String, ...> map = new TreeMap<String, ...>(new Comparator<String>() {

  public int compare(final String a, final String b) {
    return Integer.valueOf(a).compareTo(Integer.valueOf(b));
  }
});