public class Flight {
    private long flightId;
    private Airplane airplane;
    private String sourceName;
    private String destinationName;

    public long getFlightId() {
        return flightId;
    }

    public void setFlightId(long flightId) {
        this.flightId = flightId;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    //Override equals method
}

public class Airplane {
    private long id;
    private String make;
    private String airlinesCompany;

    public Airplane(long id, String make, String airlinesCompany) {
        this.id = id;
        this.make = make;
        this.airlinesCompany = airlinesCompany;
    }

    public long getId() {
        return id;
    }

    public String getMake() {
        return make;
    }

    public String getAirlinesCompany() {
        return airlinesCompany;
    }
}