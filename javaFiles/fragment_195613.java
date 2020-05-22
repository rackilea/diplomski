class FlightResponse {

    private boolean success;
    private Map<String, Map<String, Flight>> data;
    private String error;
    private String currency;

    public Map<String, Flight> getFlatData() {
        return data.entrySet()
                .stream()
                .collect(HashMap::new, (m, e) -> m.putAll(e.getValue()), Map::putAll);
    }

    // getters, setters, toString
}

class Flight {

    private BigDecimal price;
    private String airline;

    @SerializedName("flight_number")
    private int flightNumber;

    @SerializedName("departure_at")
    private String departureAt;

    @SerializedName("return_at")
    private String returnAt;

    @SerializedName("expires_at")
    private String expiresAt;

    // getters, setters, toString
}