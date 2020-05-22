public class MyClass {
    public void myMethod() {
        //Assume Customer is a Class
        Customer customer = getMyCustomer();
        synchronized(customer) {
            //only one thread at a time can access customer object
              which ever holds the lock
        }
    }
}