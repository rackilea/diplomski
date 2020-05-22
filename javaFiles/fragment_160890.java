public class BumperCar implements Vehicle {
  public void bump(Vehicle other){
    if(other instanceof BumperCar) {
        System.out.println("...");
    }
  }
}