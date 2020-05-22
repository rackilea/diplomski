String str = "Testing";
Pattern.compile(".").matcher(str)
        .results()
        .map(m -> m.group().toLowerCase())
        .collect(Collectors.groupingBy(s -> s, LinkedHashMap::new, Collectors.counting()))
        .forEach((k, v) -> System.out.println(k + " = " + v));