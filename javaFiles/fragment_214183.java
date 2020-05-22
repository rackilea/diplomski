public class FlightReservationAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlightReservationAppApplication.class, args);
    }

    @PostConstruct
    void init() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }
}