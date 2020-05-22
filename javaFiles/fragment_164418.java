Collection<String> input = Arrays.asList("1", "2", "3");
Function<String, String> mapper = x -> x + " " + x;
Predicate<String> filter = y -> !y.startsWith("1");
Collector<String, ?, List<String>> toList = Collectors.toList();

List<String> list = ((Supplier<List<String>>)toList.supplier()).get();
for (String in : input) {
    in = mapper.apply(in);
    if (filter.test(in)) {
        ((BiConsumer<List<String>, String>)toList.accumulator()).accept(list, in);
    }
}