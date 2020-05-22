Map<Integer,Integer> pairs =
    IntStream.range(1, 10000)
             .boxed()
             .flatMap(p -> IntStream.range(p+1, 10000)
                                    .filter(o -> isAmicable(p, o))
                                    .mapToObj(o -> new SimpleEntry<>(p,o)))
             .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));