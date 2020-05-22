public static List<String> groupFunc(Stream<Nums> nums, int pass) {
    return nums
            .filter(s-> s.getScore() >= pass)
            .sorted(Comparator.comparing(Nums::getScore).reversed())
            .map(Nums::getName)
            .collect(Collectors.toList());
}