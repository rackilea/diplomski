public int compare(int[] o1, int[] o2) {
    return ComparisonChain.start()
      .compare(o1[0], o2[0])
      .compare(o1[1], o2[1])
      .result();
  }