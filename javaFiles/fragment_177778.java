public static void main(String[] args) {
    class Stop {
        private final String stationName;
        private final int    passengerCount;

        Stop(final String stationName, final int passengerCount) {
            this.stationName    = stationName;
            this.passengerCount = passengerCount;
        }
    }

    List<Stop> stops = new LinkedList<>();

    stops.add(new Stop("Station1", 250));
    stops.add(new Stop("Station2", 275));
    stops.add(new Stop("Station3", 390));
    stops.add(new Stop("Station2", 210));
    stops.add(new Stop("Station1", 190));

    Stop firstStopAtStation1 = stops.stream()
            .filter(e -> e.stationName.equals("Station1"))
            .findFirst()
            .get();

    System.out.printf("At the first stop at Station1 there were %d passengers in the train.", firstStopAtStation1.passengerCount);
}