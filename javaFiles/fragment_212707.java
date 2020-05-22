import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

public static void main(String[] args) throws Exception {
    final Path path = Paths.get("path", "to", "file");
    final Map<String, Integer> counts = countOccurrences(path);
}

private static Map<String, Integer> countOccurrences(Path path) throws IOException {
    final Pattern pattern = Pattern.compile("[^A-Za-z']+");
    try (final Stream<String> lines = Files.lines(path)) {
        return lines
                .flatMap(pattern::splitAsStream)
                .collect(toMap(identity(), w -> 1, Integer::sum));
    }
}