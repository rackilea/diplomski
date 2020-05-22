public static int[] answer(int[] data, int n) {
    Map<Integer, Integer> counts = new HashMap<>();
    int elementsNeeded = 0;

    for (int i = 0; i < data.length; i++) {
      Integer currentCount = counts.get(data[i]);

      currentCount = currentCount == null ? 1 : ++currentCount;
      counts.put(data[i], currentCount);

      if (currentCount <= n + 1) {
        elementsNeeded += currentCount > n ? -n : 1;
      }
    }

    int[] resultArray = new int[elementsNeeded];
    int j = 0;

    for (int i = 0; i < data.length; i++) {
      if (counts.get(data[i]) <= n) {
        resultArray[j++] = data[i];
      }
    }

    return resultArray;
  }