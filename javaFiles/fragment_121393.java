public static void countTemperature(double t1, double t2, int r) {
    stations.stream()
            .map(station ->
                    station.getMeasurements()
                            .stream()
                            .filter(e -> Math.abs(e.getTime() - t1) <= r)
                            .count()
            )
            .forEach(System.out::println);
}