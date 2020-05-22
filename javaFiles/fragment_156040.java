public class Car{
    protected long speed=0;
    public String compareSpeed(Car anotherCar){
        if (this.speed > anotherCar.speed ) return "Faster";
        if (this.speed < anotherCar.speed ) return "Slower";
        return "Same Speed";
    }
    public void setSpeed(long speed){
        this.speed=speed;
    }
}

public static void main(){
    Car firstCar = new Car();
    Car secondCar = new Car();

    firstCar.setSpeed(10);
    secondCar.setSpeed(20);

    System.out.println(firstCar.compareSpeed(secondCar));
}