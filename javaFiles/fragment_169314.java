public class FootballMatchCSVReader {

    public List<FootballMatch> read(String filePath) throws IOException {
        return readAllLines(filePath).stream().map(line -> mapToFootballMatch(line.split(","))).collect(toList());
    }

    private List<String> readAllLines(String filePath) throws IOException {
        return Files.readAllLines(Paths.get(filePath));
    }

    private FootballMatch mapToFootballMatch(String[] args) {
        return new FootballMatch(args[0],args[1],Integer.valueOf(args[2]),Integer.valueOf(args[3]),args[4].charAt(0));
    }
}