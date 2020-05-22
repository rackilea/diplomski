public synchronized int removeCar(){
    return carLine.removeFirst();
}

public synchronized void addCar(int car){
    carLine.add(car);
}