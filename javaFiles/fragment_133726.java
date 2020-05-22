public class CarDash {
public String Car = "Car";
public static int instanceNumber;

public CarDash(){
    this.Car="Car"+ (++instanceNumber);
}

public static void main(String[] args) {
    CarDash car=new CarDash();
    CarDash car1=new CarDash();
    CarDash car2=new CarDash();

    System.out.println(car.Car+" "+car1.Car+" "+car2.Car);
}
}