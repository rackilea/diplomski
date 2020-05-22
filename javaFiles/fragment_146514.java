@ManagedBean
@RequestScoped
public class TableBean implements Serializable {

    private List<Car> cars;

    @PostConstruct
    public void init() {
        System.out.println("A new backing bean has been created");
        cars = new ArrayList<Car>();
        populateRandomCars(cars, 300000);
    }

    private void populateRandomCars(List<Car> list, int size) {
        for (int i = 0; i < size; i++) {
            list.add(new Car(i, i, UUID.randomUUID().toString()));
        }
    }

    public List<Car> getCars() {
//If i populate the list here I can still get the correct result.
//        cars = new ArrayList<Car>();
//        populateRandomCars(cars, 30000);
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}