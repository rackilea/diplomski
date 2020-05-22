import java.util.Vector;

interface Vehicle {
    public int getNumberOfWheels();
}

class Car implements Vehicle {

    final int numberOfWheels = 4;

    public int getNumberOfWheels() {
        return numberOfWheels;
    }
}

class Bicycle implements Vehicle {

    final int numberOfWheels = 2;

    public int getNumberOfWheels() {
        return numberOfWheels;
    }
}

public class Program {

    public static void main(String args[]) {
        Vector<Vehicle> vi = new Vector<Vehicle>();
        vi.add(0, new Car());
        vi.add(1, new Bicycle());
        for(Vehicle v: vi) {
            System.out.println(v.getClass().getName() 
                + " has " + v.getNumberOfWheels() + " wheels");
        }
    }
}