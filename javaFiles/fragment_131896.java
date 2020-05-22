public void findProduct(int ItemNumber){
   for (Product item : item ) {
      if (item.getItemNumber() == itemNumber){
         cart.add (item)
         break; //to leave the loop once it's found
   }