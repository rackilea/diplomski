@Benchmark
public int[][] generalIsDown() {
  for (int[] ints : waitSort) {
    Insert.general(ints, true, 0, ints.length);
  }
  return waitSort;
}

@Benchmark
public int[][] generalIsUp() {
  for (int[] ints : waitSort) {
    Insert.general(ints, false, 0, ints.length);
  }
  return waitSort;
}