class CountedFilter implements FilenameFilter {
  int limit = 0;

  public CountedFilter ( int limit ) {
    this.limit = limit;
  }

  public boolean accept(File file, String string) {
    return limit-- > 0;
  }

}