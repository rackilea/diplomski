public List<Car> getCars() {

  List<Car> listOfCars = new LinkedList<>();
  String query = "select * from cars";
  Connection connection = {get connection here};

  ...

  while (resultSet.next()) {

  String color = resultSet.getString("color");
  String brand = resultSet.getString("brand");
  Car car = new Car(color, brand);
  listOfCars.add(car); 
  }  
  return listOfCars;

  }