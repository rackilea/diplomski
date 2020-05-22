List<String> input = asList("abc", "ade", "bcd", "cc", "cdac");

List<Predicate<String>> preds = asList(
        s -> s.length() == 3, 
        s -> s.startsWith("a"), 
        s -> s.endsWith("c"));
List<Set<String>> result = input.stream().collect(multiClassify(preds, Collectors.toSet()));
// [[bcd, abc, ade], [abc, ade], [cc, abc, cdac]]