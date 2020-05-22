while(iterator.hasNext()){
   phoneNumber = iterator.next(); 
   name = iterator.next(); 
   email = iterator.next();

   // A new customer object would be created in each iteration 
   Customer cust = new Customer(email, name, phoneNumber);

   // now process customer object here
}