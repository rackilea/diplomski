private static Map<String, Customer> customers = new HashMap<> ();

  public static void addCustomer(){
       // Customers
    customers.put ("ID1", new Customer ("Jonathan", "Mifsud", "Test Address", 21345678, "L001"));
    customers.put ("ID2", new Customer ("David", "Aguis", "2nd Address", 21456778, "L002"));
    customers.put ("ID3", new Customer ("Frank", "Mamo", "example Address", 21987653, "L003"));
  }

  public static void findCustomer(){
      //retrieve Customer Details
    System.out.println("Customer with ID1 is " + customers.get("ID1"));
  }

  public static void deleteCustomer(){
      //remove Customer Details
    System.out.println("Customer Deleted is ID3 " + customers.remove("ID3"));
  }