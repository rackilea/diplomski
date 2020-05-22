public class Car {
    private double startOdo;
    private double endOdo;
    private double liters;
    public double getStartOdo() {
        return startOdo;
    }
    public void setStartOdo(double startOdo) {
        this.startOdo = startOdo;
    }
    public double getEndOdo() {
        return endOdo;
    }
    public void setEndOdo(double endOdo) {
        this.endOdo = endOdo;
    }
    public double getLiters() {
        return liters;
    }
    public void setLiters(double liters) {
        this.liters = liters;
    }
    public Car(double startOdo, double endOdo, double liters){
      this.startOdo=startOdo;
      this.endOdo=endOdo;
      this.liters=liters;
    }
}