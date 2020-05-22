public class Lake {

    private float sumOfWeight;

    public void add(Fish fish) {
        ...
        sumOfWeight += fish.getWeight();
    }

    public void remove(Fish fish) {
        ....
        sumOfWeight -= fish.getWeight();
    }

    public float getLakeWeight() {
        return this.sumOfWeight;
    }
}