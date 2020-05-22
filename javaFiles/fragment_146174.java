public class LapRanking {
    private final Map<String, Car> carsInRace = new HashMap<String,Car>();
    boolean isDirty;
    ArrayList<Car> lapTimeRankings;

    void insertCarIntoRace(Car car)
    {
        carsInRace.put(car.driverName, car);
        isDirty = true;
    }

    public List<Car> processLap(Car car){

        if (isDirty)
        {
            lapTimeRankings = new ArrayList<Car>(carsInRace.values());
            isDirty = false;
        }

        Collections.sort(lapTimeRankings);

        return lapTimeRankings;
    }

    public static void main(String[] args) {
        Car one = new Car("DriverOne");
        Car two = new Car("DriverTwo");
        Car three = new Car("DriverThree");


        LapRanking lapRanking = new LapRanking();
        lapRanking.insertCarIntoRace(car1);
        lapRanking.insertCarIntoRace(car2);
        lapRanking.insertCarIntoRace(car3);


        for (int i = 0; i < 100; i++) {
            one.setLapTime();
            two.setLapTime();
            three.setLapTime();

            lapRanking.processLap(one);
            lapRanking.processLap(two);
            lapRanking.processLap(three);
        }
    }
}