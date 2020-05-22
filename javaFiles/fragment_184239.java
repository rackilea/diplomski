/**
 * @author Stan van der Bend
 */
public class Scanner {

    private static final String CHARACTER_FILE_PATH = "data/characters";

    private static ArrayDeque<String> matches = new ArrayDeque<>(200);

    public static void main(final String... args) throws IOException {
        search();
    }

    private static void search() throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter your desired keyword: ");

        String keyword = reader.readLine();

        System.out.println("Started scanning all files...");

        long start = System.currentTimeMillis();

        try {
            Path path = Paths.get(CHARACTER_FILE_PATH);

            Files.walkFileTree(path, new SimpleFileVisitor<>() {
                @Override
                public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
                    matches.addAll(Files
                            .readAllLines(path)
                            .stream()
                            .filter(line -> line.contains(keyword))
                            .collect(Collectors.toList())
                    );
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Make sure this is in the same directory as "+CHARACTER_FILE_PATH);
        }
        long duration = System.currentTimeMillis() - start;

        System.out.println("Found "+matches.size()+" matches for the keyword "+keyword);

        matches.stream().sorted(Comparator.comparing(PlayerLogs::getDate)).forEach(System.out::println);

        System.out.println("The scan toke " + duration + "ms to complete.");
        System.out.print("For another scan type -r ");

        matches.clear();

        if(reader.readLine().equalsIgnoreCase("-r"))
            search();

        reader.close();
    }
}