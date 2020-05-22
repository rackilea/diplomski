public class Main 
{
    @EJB
    private static CarRepository carRepo;

    public static void main(String[] args) 
    {
        CarSales sys = new CarSales(carRepo);
        sys.run();
    }
}

public class CarSales 
{
    private final CarRepository carRepo;
    private final MainScreen main;

    public CarSales(CarRepository carRepo)
    {
        this.carRepo = carRepo;
        main = new MainScreen();
    }