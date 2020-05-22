public class CarDriver {

    public static void main(String[] args) {
        Car new1 = new NewCar("silver", 8000.33);
        Car new2 = new NewCar("silver", 8000.33);
        if (new1.equals(new2)) {
            new1.display();
        }

        Car used1 = new UsedCar("silver", 2500, 100000);
        Car used2 = new UsedCar("silver", 2500, 100000);
        if (used1.equals(used2)) {
            used1.display();
        }
    }
}