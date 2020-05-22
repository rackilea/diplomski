public void driveOut(Car car) {
   //loop through the array until we find the car
   for (int i=0; i < carsParked.length; i=i+1){
     if (car.getRegNo().equals(carsParked[i])){
        //we found the car, so set the space null
        carsParked[i] = null;
        carsIn=carsIn-1;
        //stop looping now
        break;
     }
   }
}