public class Flight {
    public String flightName;
    public String source;
    public String destination;
    public int flightId;
    public int flightFare;

    public Flight(String flightName, int flightId, String source,
            String destination, int flightFare) {
        super();
        this.flightName = flightName;
        this.source = source;
        this.destination = destination;
        this.flightId = flightId;
        this.flightFare = flightFare;
    }

    public String getFlightName() {
        return flightName;
    }

    public int getFlightId() {
        return flightId;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public int getFlightFare() {
        return flightFare;
    }

    public boolean searchFlight(int originalFlightId, int newFlightId) {
        if (originalFlightId == newFlightId)

        {
            return true;
        } else {
            return false;
        }

    }
}