final List<Character> maxOccuringChars = chars.stream()
        .collect(Collectors.collectingAndThen(Collectors.groupingBy(Function.identity(), Collectors.counting()),
                map -> map.entrySet().stream()
                        .filter(entry -> entry.getValue().longValue() == map.entrySet().stream()
                                .max(Map.Entry.comparingByValue()).get().getValue().longValue())
                        .map(Map.Entry::getKey).collect(Collectors.toList())));