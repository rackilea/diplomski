class Car{
    private Engine engine;

    //Constructor not shown

    //a getter method
    public getEngine(){
        return engine;
    }
}

class Runner{
    public static void main(String[] args){
        Car c = new Car();
        Engine engine = car.getEngine();  //retrieve engine from car (for whatever use)
    }
}