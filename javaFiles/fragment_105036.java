double average = bList.stream()
        .map(B::getaList)
        .flatMap(List::stream)
        .filter(a -> a.getKey().equals(k))
        .mapToDouble(A::getValue)
        .average()
        .orElse(Double.NaN);