@Component
public class CarMapper <Car, CarDTO> {
    public Car map(CarDTO carDTO) {
        //impl
    }

    public CarDTO mapReverse(Car car) {
        //impl
    }

    public Class<Car> getEntityClass() {
        return Car.getClass();
    }
    public Class<CarDTO> getDtoClass() {
        return CarDTO.getClass();
    }
}