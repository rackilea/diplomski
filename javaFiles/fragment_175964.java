public abstract class Vehicle {

    public void Run() {
        //code that will always run
        addToRunningVehicleList();

        //code that can be overriden
        RunImpl();
    }

    protected virtual void RunImpl() { }
}

public class Car : Vehicle {

    protected override void RunImpl() {
        carRunningAnimation();
    }

}