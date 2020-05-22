public class Parser {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("sampledatamap.txt");

        try(Stream<String> lines = Files.lines(path)) {
            List<Map<String, String>> collect = lines
                    .map(Parser::toMap)
                    .collect(Collectors.toList());

            System.out.println(collect);
        }
    }

    static Map<String, String> toMap(String line) {
        return Stream
                .of(line.split(","))
                .map(s -> s.split("="))
                .collect(Collectors.toMap((String[] s) -> s[0], (String[] s) -> s[1]));
    }
}