public class APIData {

    private double min;
    private double max;
    private double average;
    private int amount;

    public void addValues(double[] values) {
        min += values[0];
        max += values[1];
        average += values[2];
        amount++;
    }

    public double getAPIMin() {
        return min / amount;
    }

    public double getAPIMax() {
        return max / amount;
    }

    public double getAPIAverage() {
        return average / amount;
    }

}