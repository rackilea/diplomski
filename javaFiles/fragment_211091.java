public abstract class Plane{
    protected int id;
    protected Time initialRemainingFuelTime;
    protected Time initializedTime;

    public Parent(int id, Time currentTime) {
        this.id = id;
        initializedTime = currentTime;
        initialFuelTime = generateInitialFuelTime();
    }

    protected Time generateInitialFuelTime() {
        Random r = new Random();
        int min = getMinFuelTime().getMinute() + 1;
        int range = getMaxFuelTime().getMinute() - getMinFuelTime().getMinute();
        int initialFuelTime = r.nextInt(min) + range;
        return new Time (0, randomMinute , 0);
    }

    protected abstract Time getMinFuelTime();
    protected abstract Time getMaxFuelTime();

}