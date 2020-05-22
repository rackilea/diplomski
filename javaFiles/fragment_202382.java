class Value {
    private int count;
    private double sumMaxTemp;
    private double sumMinTemp;
    Value(double maxTemp, double minTemp) {
        this.count = 1;
        this.sumMaxTemp = maxTemp;
        this.sumMinTemp = minTemp;
    }
    void add(double maxTemp, double minTemp) {
        this.count++;
        this.sumMaxTemp += maxTemp;
        this.sumMinTemp += minTemp;
    }
    double getAverageMaxTemp() {
        return this.sumMaxTemp / this.count;
    }
    double getAverageMinTemp() {
        return this.sumMinTemp / this.count;
    }
}