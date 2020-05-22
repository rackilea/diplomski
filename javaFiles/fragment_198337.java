public abstract class Vehicle {
    private int gasTank;
    private int milesDriven;
    private int mileage;
    void Vehicle(int gas, int milesDriven,int mileage) {
        gasTank = gas;
        this.milesDriven = milesDriven;
        this.mileage=mileage;
    }
    public void move(int miles){
     gasTank -=mileage * miles;
    milesDriven += miles; 
}


}