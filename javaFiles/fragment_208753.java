interface Car {}
class Car1 implements Car {}

private void doStuff {
    Car car = queryCar();
    if(car instanceof Car1) {
        Car1 theCar = ((Car1) car);
        theCar.car1OnlyMethod();
        //Or
        ((Car1) car).car1OnlyMethod();
    }
}