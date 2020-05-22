class WeatherStation {
    List<Measurements> measurements;
    int days;

    public WeatherStation(int days) {
        this.days = days;
        this.measurements = new ArrayList<>();
    }

    public void addMeasurements(float temperature, float wind, float humidity, float visibility, Date date) {
        measurements.add(new Measurements(temperature, wind, humidity, visibility, date));
        for(Measurements m: measurements) {
            if(m.date.before(Date.from(Instant.now().minus(days, ChronoUnit.DAYS)))) {

            }
        }

    }
}