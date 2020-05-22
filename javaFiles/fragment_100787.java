public NamedList getStatistics() {
    NamedList list = super.getStatistics();
    if (core != null) {
      list.add("indexSize", NumberUtils.readableSize(getIndexSize()));
    }
  }