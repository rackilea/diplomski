String fileName = "shell.txt";
try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

    Map<String, String> result = stream
            .filter(line -> line.matches("\\w+=\\w+"))
            .map(line -> line.split("="))
            .collect(Collectors.toMap(a -> a[0], a -> a[1]));

} catch (IOException e) {
    e.printStackTrace();
}