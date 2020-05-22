public class Main {

    public static void main(String[] args) throws ParseException, IOException, InterruptedException {

        Manufacturer[] objManufacturer = new Manufacturer[10];
        Manufacturer obj1 = new Manufacturer();
        objManufacturer[0] = obj1;
        System.out.println(objManufacturer[0].getManufacturer());
        Car car1 = new Car(2014, "Gol", 20000, 0, null);
        obj1.addCar(car1);

        int numOfCars = obj1.getNumOfCars();
        Car[] cars = obj1.getCars();
        for (int i = 0; i < numOfCars; i++) {
           Car car = cars[i];
           System.out.println(car.getModel());
        }

    }

}