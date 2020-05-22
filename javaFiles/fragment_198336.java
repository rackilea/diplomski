public abstract class Vehicle {
    private int gasTank;
    private int milesDriven;

    void Vehicle(int gas, int milesDriven) {
        gasTank = gas;
        this.milesDriven = milesDriven;
    }
    // make this function abstract
    abstract void move(int miles); 

}

public class Hyundai Sonata extends Vehicle {
    private int mileage;

    void Hyundai Sonata () { super(40, 5000); }

    void getMileage() {return mileage;}
    //override it here
    @Override
    public void move(int miles){
    gasTank -=this.getMileage() * miles;
        milesDriven += miles; 
    }

}