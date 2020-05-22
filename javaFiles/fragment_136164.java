// skipped non-relevant parts(e.g. DAO injection) for brevity
public class CarServiceImpl implements CarService {

public ManufacturerDao manufacturerDao;
public BillingDao billingDao;
public CarDao carDao;

public void repairCar(Car car) {
    // get the car part
    Model model = car.getMissingPart();
    CarPart carPart = manufacturerDao.getNewCarPart(model);
    // install it and save the car
    car.installCarPart(carPart);
    car.setStatus(Status.REPAIRED);
    carDao.updateCar(car);
    // bill the owner
    billingDao.bill(car.getOwner());
}