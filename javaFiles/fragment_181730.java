public class VehicleModule implements Module {
    @Override
    public void configure(Binder binder) {
        binder.bind(DieselEngine.class).toProvider(DieselEngineProvider.class);
        binder.bind(PetrolEngine.class).toProvider(PetrolEngineProvider.class);
        binder.bind(Bike.class).toProvider(BikeProvider.class);
    }
}

public class DieselEngineProvider implements Provider<DieselEngine> {

    @Inject
    public DieselEngineProvider() {
        //if DieselEngine has any dependencies, they can be injected in the constructor
        //stored in a field in the class and used in the below get() method
    }

    @Override
    public DieselEngine get() {
        return new DieselEngine();
    }
}

public class VehicleFactory {

    private final CarFactory carFactory;
    private final Provider<Bike> bikeProvider;

    @Inject
    public VehicleFactory(CarFactory carFactory, Provider<Bike> bikeProvider) {
         this.carFactory = carFactory;
         this.bikeProvider = bikeProvider;
    }

    public Bike createBike() {
        return bikeProvider.get();
    }

    public Car createDieselCar() {
         return carFactory.createDieselCar();
    }

    public Car createPetrolCar() {
         return carFactory.createPetrolCar();
    }
}

public class CarFactory {
    private final Provider<DieselEngine> dieselEngineProvider;
    private final Provider<PetrolEngine> petrolEngineProvider;

    @Inject
    public CarFactory(Provider<DieselEngine> dieselEngineProvider, Provider<PetrolEngine> petrolEngineProvider) {
        this.dieselEngineProvider = dieselEngineProvider;
        this.petrolEngineProvider = petrolEngineProvider;
    }

    public Car createDieselCar() {
        return new Car(dieselEngineProvider.get());
    }

    public Car createPetrolCar() {
        return new Car(petrolEngineProvider.get());
    }
}