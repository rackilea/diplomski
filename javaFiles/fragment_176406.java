public class CarManufacturer <T extends Car> {
    private Supplier<T> carType;
    private List<T> carsProduced = new LinkedList<>();

    public CarManufacturer(Supplier<T> carType) {
        this.carType = carType;
    }

    public void produceCar() {
        this.carsProduced.add(carType.get());
    }

}

public class Main {
    public static void main(String[] args) {
        CarManufacturer<Convertible> convertibleCarManufacturer = new CarManufacturer<>(Convertible::new);
        convertibleCarManufacturer.produceCar();
    }
}