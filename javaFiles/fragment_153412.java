public class AirportConsumer implements AirportAPI {

    @Override
    public Stream<Airport> getAirports() {
        Stream<String> stream = null;
        try {
            stream = Files.lines(Paths.get("resources/planes.txt"))
                                   .map(line -> createAirport(line));
        } catch (IOException e) {
            stream = Stream.empty();
            e.printStackTrace();
        }
        return stream;
    }

    private Airport createAirport(final String line) {
        final String[] fields = line.split(";");
        return new Airport(fields[0].trim(), 
                           fields[1].trim(), 
                           fields[2].trim(), 
                           Integer.parseInt(fields[3].trim()));
    }
}