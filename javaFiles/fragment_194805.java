Arrays.sort(hand, new Comparator<int[]>() {
  public int compare(int[] o1, int[] o2) {
    if (o1[0] == o2[0]) {
      return Integer.compare(o1[1], o2[1]);
    } else {
      return Integer.compare(o1[0], o2[0]);
    }
  }
});