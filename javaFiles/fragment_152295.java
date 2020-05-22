public static void main(String[] args) throws IOException {
    List<String> lines = Files.readAllLines(Paths.get(("input.txt")));
    for (String line : lines) {
        System.out.println(line);
    }
}