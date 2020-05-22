public class Car implements Cloneable {
    private static Car car = null;

    public static Car GetInstance() {
        if (car == null) {
            car = new Car();
        }
        return car;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

Car car = Car.GetInstance();
Car car1 = (Car) car.clone();
System.out.println(car.hashCode());
System.out.println(car1.hashCode());