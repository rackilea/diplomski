List<String> list = Arrays.asList("a", "b", "c", "d", "e");

System.out.println(list.stream()
    .collect(StringBuilder::new,
             (a, b) -> a.append(a.toString()).append(b),
             (a, b) -> a.append(a.toString()).append(b))); // BROKEN -- NOT ASSOCIATIVE