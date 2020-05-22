Set<String[]> mySet = new TreeSet<>(new Comparator<String[]>() {

  @Override
  public int compare(String[] o1, String[] o2) {
    return Arrays.equals(o1, o2)? 0 : Arrays.hashCode(o1) - Arrays.hashCode(o2);
  }

});