class IntPair {
        final int input, result;
        IntPair(int i, int r) { input = i; result = r; }
    }

    Map<Integer, List<Integer>> output =
        IntStream.range(1, 10)
            .mapToObj(i -> new IntPair(i, i % 2))
            .filter(pair -> pair.result != 0)
            .collect(groupingBy(pair -> pair.result,
                mapping(pair -> pair.input, toList())));