public class ParseCSVs{

    public static void main(String[] args) throws Exception {
        File file = new File("./input//SIMNumbers.csv");
        Files.lines(file.toPath(),StandardCharsets.UTF_8)
             .substream(1)
             .map(line -> Arrays.toList(line.split(",")))
             .forEach(System.out::println);
    }
}