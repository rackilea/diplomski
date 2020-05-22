class SMP {
  static int[] segments = {16, 19, 22, 26};
  static String[] labels = {"horse", "cow", "mule"};

  static int[][] labelIndicesForSegments = {{0, 1, 2}, {0, 2}, {2, 1, 0}, {2}};
  static int[][] segmentIndicesForLabels = {{3, 1, 2, 0}, {0, 2, 1}, {3, 2, 1}};

  static int[] matching = new int[segments.length];
  static int[] nextLabel = new int[segments.length]; // A simple pointer to the next label to test for each segment (the current position in its own preference list) 

  public static void main(String[] args) {
    // initialize all matchings
    for (int i=0; i<matching.length; i++) {  
      matching[i] = -1;
      nextLabel[i] = 0;
    }

    // While there is at least one free label and one free segment  
    while (canEnhance()) {
      int unmatched = findUnmatchedSegment(); // Pick an unmatched segment
      int label = labelIndicesForSegments[unmatched][nextLabel[unmatched]];

      nextLabel[unmatched]++;

      int matchedSegment = getMatchedSegment(label);

      if (matchedSegment == -1) { // The label is not matched
        matching[unmatched] = label;
      } else {
        if (labelPrefersSegment(label, matchedSegment, unmatched)) {
          matching[unmatched] = label;
          matching[matchedSegment] = -1;
        }
      }
      for (int i = 0; i < matching.length; i++) {
                if (matching[i] != -1)
                  System.out.println("Segment "+segments[i]+" matched with label "+labels[matching[i]]);
              }
      System.out.println("-----");
    }

    for (int i = 0; i < matching.length; i++) {
      if (matching[i] != -1)
        System.out.println("Segment "+segments[i]+" matched with label "+labels[matching[i]]);
    }
  }

  public static boolean labelPrefersSegment(int label, int currentSegment, int newSegment) {
    int[] preferenceList = segmentIndicesForLabels[label];

    for (int i = 0; i < preferenceList.length; i++) {
      if (preferenceList[i] == currentSegment) return false;
      if (preferenceList[i] == newSegment) return true;
    }
    return false;
  }

  public static int getMatchedSegment(int label) {
    for (int i=0; i<matching.length; i++) {
      if (matching[i] == label) return i;
    }
    return -1;
  }

  public static int findUnmatchedSegment() {
    for (int i=0; i<matching.length; i++) {
      // The segment need to be free and to still have labels to test
      if (matching[i] == -1 && nextLabel[i] < labelIndicesForSegments[i].length) {
        return i;
      }
    }
    return -1;
  }

  public static boolean canEnhance() {
    return findUnmatchedSegment() != -1;
  }
}