public static int[][] blockSplitter(int[] data) {
    List<int[]> blocks = new ArrayList<int[]>();
    for (int i = 0; i < data.length;) {
      int blockSize = data[i];
      int[] block = Arrays.copyOfRange(data, i + 1, i + blockSize + 1);
      blocks.add(block);
      i += (blockSize + 1);
    }
    return (int[][]) blocks.toArray(new int[blocks.size()][]);
  }