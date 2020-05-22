public boolean sellPass() {
   //Check if you have a pass to sell
   if (availablePasses > 0) {
       //you have passes to sell
       moneyMade += moneyPerPass; // add the money
       availablePass--; //decrement pass counter 
       return true;
   }
   return false; // not enough passes to sell
}