public void drop(int index) {
     NewCar removedCar = carList.remove(index);
     if (removedCar != null) {
       System.out.println("Removed car at index: " + index)
     }
     else {
        System.out.println("Something went wrong"); 
     }
   }