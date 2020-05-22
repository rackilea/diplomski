public static <T> Collector<T,?,List<T>> toSortedList() {
    return Collectors.collectingAndThen(Collectors.toList(), 
                                       l -> l.stream().sorted().collect(toList()));
}

 List<String> beansByDomain = beans.stream()
        .collect(groupingBy( (ObjectInstance oi) -> oi.getObjectName().getDomain(),
                            mapping((ObjectInstance oi) -> oi.getObjectName().getCanonicalKeyPropertyListString(),
                                    toSortedList())));