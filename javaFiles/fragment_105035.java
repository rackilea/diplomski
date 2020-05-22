double average = bList.stream()
        .flatMap(b -> b.aList.stream())
        .filter(a -> a.key.equals(k))
        .mapToDouble(a -> a.value)
        .average()
        .orElse(Double.NaN);