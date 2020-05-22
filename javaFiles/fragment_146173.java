public class LapRanking {
    private final Map<String, Car> carsInRace = new HashMap<String,Car>();
    ArrayList<Car> lapTimeRankings;

    public List<Car> processLap(Car car){

        Car oldcar = carsInRace.put(car.driverName, car);

        if (oldcar == null)
        {
            lapTimeRankings = new ArrayList<Car>(carsInRace.values());
        }

        Collections.sort(lapTimeRankings);

        return lapTimeRankings;
    }