Path path = Paths.get("src/main/resources", "data.txt");
try (Stream<String> lines = Files.lines(path)) {
    String[] winner = lines.map(l -> l.split(" "))
            .reduce((a1, a2) -> Integer.valueOf(a1[2]) < Integer.valueOf(a2[2]) ? a1 : a2)
            .orElseThrow(IllegalArgumentException::new);
    System.out.println(Arrays.toString(winner));
}