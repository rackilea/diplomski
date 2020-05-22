public class CarHandler {

    private List<Car> cars;

    @EJB
    private CarService carService;

    @PostConstruct
    public void init() {
        cars = carService.list();
    }

    // ...
}