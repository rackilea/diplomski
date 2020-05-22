Collection<E> maxB = list.stream()
        .collect(Collectors.groupingBy(E::getA,
                Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparing(E::getB)),
                        Optional::get)))
        .values();