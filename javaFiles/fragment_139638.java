public void driveIn(Car car) {
   //loop through the array until we find a null spot, 
   //then park the car
   for (int i=0; i < carsParked.length; i=i+1){
     if (carsParked[i] == null){
        //we found the car, so set the space null
        carsParked[i] = car.getRegNo();
        carsIn=carsIn+1;
        //stop looping now
        break;
     }
   }
}