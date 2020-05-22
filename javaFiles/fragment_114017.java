if (carSelect < 1){
     System.out.println("Your input is less than 1 ");  
} else if (carSelect > 3) {
     System.out.println("Wrong input ");
} else {   
   //valid input, let us check the car selected
   System.out.println("Great you choose " +carList[carSelect]);
}