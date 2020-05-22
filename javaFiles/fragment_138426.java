public interface Car {

    public void drive(int Speed, int Gear); // for cars which have gears

    public void drive(int Speed); // for cars which do not have gears
}



public class CarAdapter implements Car {

    @Override
    public void drive(int Speed, int Gear) {
        // TODO Auto-generated method stub

    }

    @Override
    public void drive(int Speed) {
        // TODO Auto-generated method stub

    }

}


public class AdvancedCar extends CarAdapter {

    @Override
    public void drive(int Speed) {
        // TODO Auto-generated method stub
        super.drive(Speed);
    }

    @Override
    public void drive(int Speed, int Gear) {
        // TODO Auto-generated method stub
        super.drive(Speed, Gear);
    }

}


public class SimpleCar extends CarAdapter {

    @Override
    public void drive(int Speed) {
        // TODO Auto-generated method stub
        super.drive(Speed);
    }


}