Arrays.sort(array, new Comparator<Object[]>() {
  @Override
  public int compare(Object[] o1, Object[] o2) {
    Integer i1 = (Integer) (o1[0]);
    Integer i2 = (Integer) (o2[0]);
    return i1.compareTo(i2);
  }
});