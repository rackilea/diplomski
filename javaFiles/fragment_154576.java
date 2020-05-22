public class TicketDto {
private int ticket_id;

private int place;

private String name;

private String surname;

private Flight flight;

private Customer customer_id;

@JsonProperty("flight_id")
private void unpackNested(Integer flight_id) {
    this.flight = new Flight();
    flight.setFlight_id(flight_id);
}