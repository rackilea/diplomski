private static List<Integer> randomIntegerArray(int n) {
    List<Integer> list = new ArrayList<>();
    for(int i = 0; i < n; i++) {
      list.add((int) Math.random()); // always returns 0
    }
    return list;
  }