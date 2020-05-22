Vehicle[] carList = {new Vehicle(2, "X"), new Vehicle(4, "Y")};
...
int time = 2;
while(time < 10){
    for(Vehicle car : carList){
         int pos = time - car.returnTime();
         aRoad[pos-1] = 0;
         aRoad[pos] = car.returnDest();
    }
    ...
}