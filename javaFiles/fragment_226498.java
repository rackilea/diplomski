private static int findCandidateRow(final int[][] m, final int value) {
    int lower = 0;
    int upper = m.length;
    int middle = (upper + 1) / 2;
    while (middle != m.length 
        && middle != 1
        && (m[middle][0] < value || m[middle - 1][0] > value)) {
      if (m[middle][0] < value) {
        lower = middle;
      } else {
        upper = middle;
      }
      middle = lower + (upper - lower + 1) / 2;
    }
    return middle;
  }