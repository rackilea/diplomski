Optional<String> o = Optional.of("text");
Optional<CharSequence> cs = o.map(Function.identity());

List<String> l = Arrays.asList("foo", "bar", "baz");
Map<Serializable, List<String>> map1
    = l.stream().collect(Collectors.groupingBy(Function.identity()));