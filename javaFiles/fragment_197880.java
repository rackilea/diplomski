int groupSize = aFor.length;
 while (groupSize >= 0) {
      //get aFor value
      for (int i = 0; i <= aFor.length - groupSize; i++) { // note this change
        int[] tempA = Arrays.copyOfRange(aFor, i, i + groupSize);

        //loop through bRev and check for matches
        for (int j = 0; j <= bRev.length - groupSize; j++) { // note this change
          int[] tempB = Arrays.copyOfRange(bRev, j, j+groupSize);

          if (Arrays.equals(tempA, tempB)) {
            return groupSize;
          }
        }
      }
      groupSize--;
  }
  return 1;
}