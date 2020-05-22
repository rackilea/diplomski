public int getCustomer(String IdToFind){   
  if(Driver.customers.length > 0) {            
    for (int index = 0; index<Driver.customers.length;index++){
      if (Driver.customers[index].getCustomerID().equalsIgnoreCase(IdToFind))
         return index;         //ID found                                      
     }
    return -1;   //ID not found
   } else {
      return -1  //ID not found, as no customers in driver object
   }                              
}