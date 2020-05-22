interface ParticipatorWrapper{
    public void doSomething();
}

class CustomerWrapper implements ParticipatorWrapper{
    Customer customer;
    public void doSomething(){
       //do something with the customer
    }
}

class SaleREpresentativeWrapper implements ParticipatorWrapper{
    SaleRepresentative salesRepresentative;
    public void doSomething(){
       //do something with the salesRepresentative
    }

}

class ClientOfWrapper{
    public void mymethod(){
         ParticipatorWrapper p = new ParticipatorWrapper(new Customer());
         p.doSomething();
   }
}