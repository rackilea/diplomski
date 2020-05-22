Vehicle car1 = new Vehicle(2, "X");
Vehicle car2 = new Vehicle(4, "Y");   
...
int time = 2;
while(time < 10){
   // calculate road positions
   int car1Pos = time - car1.returnTime();
   int car2Pos = time - car2.returnTime();

   aRoad[car1Pos - 1] = 0;
   aRoad[car1Pos] = car1.returnDest();

   aRoad[car2Pos - 1] = 0;
   aRoad[car2Pos] = car1.returnDest();
   ...
}