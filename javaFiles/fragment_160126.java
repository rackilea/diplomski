Map.Entry<Integer, Integer> max = IntStream.range('a', 'z').boxed().collect(Collectors.toMap(i -> i, i -> list.stream()
        .filter(k -> k.contains("" + (char) i.intValue()))
        .map(String::length)
        .mapToInt(Integer::new)
        .sum()))
        .entrySet().stream()
        .max((e1, e2) -> e1.getValue().compareTo(e2.getValue())).get();

System.out.println((char)max.getKey().intValue() + ":" + max.getValue());