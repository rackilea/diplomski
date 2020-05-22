Map<Integer, Long> counts = IntStream.of(arr).boxed()
        .collect(Collectors.groupingBy(x -> x, Collectors.counting()));
Long max = counts.values().stream().max(Comparator.naturalOrder()).get();
int mode = counts.entrySet().stream()
        .filter(e -> e.getValue().equals(max))
        .min(Comparator.comparing(Entry::getKey)).get().getKey();