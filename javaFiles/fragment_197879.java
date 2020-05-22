while (groupSize < aFor.length) {
      //get aFor value
      for (int i = 0; i < aFor.length; i++) {
        int[] tempA = Arrays.copyOfRange(aFor, i, i + groupSize);

        //loop through bRev and check for matches
        for (int j = 0; j < bRev.length; j++) {
          int[] tempB = Arrays.copyOfRange(bRev, j, j+groupSize);

          if (Arrays.equals(tempA, tempB)) {
            maxCount = groupSize;
          }
        }
      }
      groupSize++;
  }