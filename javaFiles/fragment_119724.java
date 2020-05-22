List<Integer> numbers = Arrays.asList(100, 10, 4000, 9, 3000, 1024, 15, 660, 999);
    List<Integer> range = Arrays.asList(20, 300, 500, 1000, 10000); // sorted
    Function<Integer, Integer> between = n -> {
        for (Integer in : range) {
            if (in >= n)
                return in;
        }
        return -1;
    };
    Map<Integer, List<Integer>> grouped = numbers.stream().collect(Collectors.groupingBy(between));
    System.out.println(grouped);