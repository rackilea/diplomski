List<Double> list = Arrays.asList(1d, 5d, 3d, 6d);

List<Double> averages = IntStream.range(0, list.size())
        .filter(i -> (i % 2 == 0))
        .mapToObj(i -> list.get(i))
        .collect(Collectors.toList());

List<Double> sums = IntStream.range(0, list.size())
        .filter(i -> (i % 2 != 0))
        .mapToObj(i -> list.get(i))
        .collect(Collectors.toList());