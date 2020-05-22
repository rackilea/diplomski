Customer.em().getTransaction().begin(); 
for ( int i=1; i<=100000; i++ ) {
   ....
   myCustomer.save();
   if (i%1000==0) { 
       //Customer.em().getTransaction().commit();           
       Customer.em().flush(); 
       Customer.em().clear();
       //Customer.em().getTransaction().begin(); 
   }
}
Customer.em().getTransaction().commit();