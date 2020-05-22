List<String> result = Files.readAllLines(Paths.get(fileName)).stream()
        .filter(s -> !s.startsWith("//"))
        .flatMap(s -> Stream.of(s.split(",")))
        .filter(s -> !s.matches("\\d+(\\.\\d*)?"))
        .collect(Collectors.toList());
    System.out.println(result);