// get the Instance calling to the  getProductByID
   Product p = getHelper().getProductByID(p.getId())

   //modify any value of the product
   p.setFirstName("asd");

   //call the update
   ret = getHelper().updateProduct(p);