for (Car c : listOfCars) //list contains Fords, Porches, Fiats, etc
 {
   try {
      c.drive(); //All sub-classed Cars contain this exact method 
   }
   catch (UnknownIgnitionException e)
   {
   //As all subclassed cars are restricted to the same method signature, you can be sure what exceptions all Cars throw
   }
 }