interface CustomerNumber {
    String getCustomerNumber();
}

public class Customer implements CustomerNumber {
  ...
  public String getCustomerNumber();
  ...
}

public class Applicant implements CustomerNumber {
   ....
   private Customer c;
   public Customer getCustomer() { return c; }
   public String getCustomerNumber() { return getCustomer().getCustomerNumber(); }
   ...
}