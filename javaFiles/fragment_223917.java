List<Double> fractions = Arrays.stream(chars).boxed()
    .collect(Collectors.collectingAndThen(
        Collectors.groupingBy(Function.identity(), Collectors.counting()),
        map -> {
            double total = map.values().stream().mapToInt(Long::intValue).sum();
            return IntStream.rangeClosed(0, 256)
                .mapToObj(i -> map.getOrDefault(i, 0L)/total)
                .collect(Collectors.toList());
        }));