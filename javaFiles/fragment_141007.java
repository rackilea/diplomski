public class Car {
  public String model;
  public int numberOfWheels;
  public String color;
  public int yearOfProduction;

  public static void main(String[] args) {
    cars()
       .toSortedList(Car::compareModel)
       .subscribe(System.out::println) ;

    cars()
       .toSortedList(Car::compareYear)
       .subscribe(System.out::println) ;

  }

  private static Integer compareModel(Car car1, Car car2) {
    return car1.model.compareTo(car2.model);
  }

  private static Integer compareYear(Car car1, Car car2) {
    return Integer.valueOf(car1.yearOfProduction)
            .compareTo(car2.yearOfProduction);
  }

  private static Observable<Car> cars(){
    Car car1 = new Car();
    car1.model = "robin";
    car1.color = "red";
    car1.numberOfWheels = 3;
    car1.yearOfProduction = 1972;
    Car car2 = new Car();
    car2.model = "corolla";
    car2.color = "white";
    car2.numberOfWheels = 4;
    car2.yearOfProduction = 1992;
    return Observable.just(car1, car2);
  }

  public String toString(){
    return model;
  }
}