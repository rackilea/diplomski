public class Type1Plane extends Plane{
    private Time minFuelTime = new Time(0, 20, 0) // 20 minute
    private Time maxFuelTime = new Time(0, 40, 0) // 40 minute

    public Type2Plane (int id, Time currentTime) {
        super(id, currentTime);
    }

    protected Time getMinFuelTime() {
          return minFuelTime;
    }

    protected Time getMaxFuelTime() {
          return maxFuelTime;
    }
}