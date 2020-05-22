package OOO;

class Car {
    class Engine {

        void display() {
            System.out.println("this is inner diaplay() method");
        }
    }
}

public class Sample8InnerClassCar {

    Car c = new Car();
    Car.Engine e = c.new Engine();
}