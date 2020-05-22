private class MyObjectComparator<MyObject> implements Comparator<MyObject> {

  /**
   * {@inheritDoc}
   */
  @Override
  public int compare(MyObject o1, MyObject o2) {
     return o2.getSequenceNumber() - o1.getSequenceNumber();
  }

}