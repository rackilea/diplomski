public class User {} //simple user just to verify not null

public class Car {
    private Long id;
    private User user;
    //getters ans setters
}

public class CarDao { //with stub methods because we will mock it
    public void persist(Car car) {}
    public Car getById(Long id) {return new Car();}
}

public class CarHandler {
    private CarService carService; //with setter
    public void foo() { // we will test this method
        User user = new User(); //it's like your example but without additional fields (like color)
        Car car = carService.create(user); // here we build and store new car
        Car sameCar = carService.findById(car.getId());
        assert car == sameCar;
    }
}

public class CarService {
    private CarDao carDao; //with setter
    public Car create(User user) {
        Car car = new Car();
        car.setUser(user);
        carDao.persist(car); //here car should get id
        return car;
    }

    public Car findById(Long id) {
        Car car = carDao.getById(id);
        User user = car.getUser(); //this user should be not null in test
        assert user != null; //this assert for verify user
        return car;
    }
}