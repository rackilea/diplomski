public class JavaAplication25 {

public static void main(String[] args) {

    Car c = new Car(200,5547,50);
    Car c2 = new Car(150,5087,100);

    c.display();
    c2.display();

    Car cars[] = {c,c2}; //array of cars
    Calculate calculateFuel = new Calculate();
    System.out.println("Total fuel:" + calculateFuel.sumFuel(cars));
}

private static class Vehicle {
    private int speed;
    private int nr;

    Vehicle(int speed, int nr) {
        this.speed=speed;
        this.nr=nr;
    }
    protected void display() {
        System.out.println("Speed: "+speed );
        System.out.println("Nr: "+nr);
    }
}

private static class Car extends Vehicle {
    private int fuel;

    Car(int speed, int nr, int fuel) {
        super(speed, nr);
        this.fuel=fuel;
    }

    protected void display() {
        super.display();
        System.out.println("Fuel: "+ fuel);
    }

}

private static class Calculate {
    private int sum = 0;

    private int sumFuel(Car arrayOfCars[]) {
        for (int i=0; i<arrayOfCars.length; i++) {
            sum = sum + arrayOfCars[i].fuel;
        }
        return sum;
    }
}
}