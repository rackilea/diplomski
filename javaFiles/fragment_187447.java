public static int[] getDuplicatesStreamsToArray(int[] input) {

      int[] dups = Arrays.stream(input).boxed().collect(
            Collectors.groupingBy(Function.identity(),
                  Collectors.counting())).entrySet().stream().filter(
                        e -> e.getValue() > 1).mapToInt(
                              e -> e.getKey()).toArray();
      return dups;
   }