Comparator<IssueTest> comparator = new Comparator<IssueTest>() {
  private int getStringPosition(String str) {
    if(str.equals("task")) {
      return 0;
    } else if (str.equals("bug")) {
      return 1;
    } else if (str.equals("story")) {
      return 2;
    } else if (str.equals("epic")) {
      return 3;
    } else {
      throw new AssertionError();
    }
  }
  public int compare(IssueTest a, IssueTest b) {
    return getStringPosition(a.getType()) - getStringPosition(b.getType());
  }
};
Collections.sort(list, comparator);