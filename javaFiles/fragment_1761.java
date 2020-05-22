class Car implements Cloneable {
  String name;
  public Car(String n) {
    name = n;
  }

  public static void main(String[] args) throws Exception {
    Car c1 = new Car("Lightning McQueen");
    Car c2 = (Car) c1.clone();
    System.out.println(c2.name);
  }
}