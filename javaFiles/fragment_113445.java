return list
        .stream()
        .map(ClassOfToDigits::toDigits)
        .flatMap(List::stream)
        .mapToLong(Long::longValue)
        .sum();