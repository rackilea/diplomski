List<FloatBalance> result = floats.stream()
        .collect(Collectors.groupingBy(FloatBalance::getCurrency,
                Collectors.maxBy(Comparator.comparing(FloatBalance::getCreatedDate))))
        .values().stream()
        .filter(Optional::isPresent)
        .map(Optional::get)
        .collect(Collectors.toList());