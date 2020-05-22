String fileName = "shell.txt";
try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

    Map<String, List<String>> result = stream
            .filter(line -> line.matches("[^=]+=[^=]+")) // filter only the lines which contain one = signe
            .map(line -> line.split("=")) // split with = sign
            .collect(Collectors.groupingBy(e -> e[0], Collectors.mapping(e -> e[1], Collectors.toList())));

    result.forEach((k, v) -> System.out.println(k + " : " + v));
} catch (IOException e) {
    e.printStackTrace();
}