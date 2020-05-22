List<CharacterFrequency> resultSet =
                new BufferedReader(new FileReader("C:/text.txt"))
                .lines()
                .flatMap(s -> s.chars().mapToObj(a -> (char)a))
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.summingInt(e -> 1)))
                .entrySet()
                .stream()
                .map(e -> new CharacterFrequency(e.getKey(), e.getValue()))
                .collect(Collectors.toCollection(ArrayList::new));