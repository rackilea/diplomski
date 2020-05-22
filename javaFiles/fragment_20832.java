public static int findCandidate(int ... nums) {
    Map<Integer, List<Integer>> map =
    Arrays.stream(nums)
          .boxed()
          .collect(Collectors.groupingBy(x -> x));
    int value = 
          map
          .entrySet().stream()
          .max((e1, e2) -> Integer.compare(e1.getValue().size(), e2.getValue().size()))
          .map(e -> e.getKey())
          .get();
    int result = map.get(value).size();
    return result > nums.length / 2 ? value : -1;
}