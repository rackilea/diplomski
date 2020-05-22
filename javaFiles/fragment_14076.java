@Test
public void addCustomer() {
    CustomerRepository repo = new CustomerRepository();
    String customerName = "Anna";
    String customerAddress = "London";
    int customerPhone =  1010101;
    int customerID = 1000;
    // Mock the System IN to read these values
    // ...
    // invoke the method under test
    repo.addCustomer();
    // assert that the repo contains the new object
    Customer actual = repo.findCustomerById(customerID);
    assertNotNull(actual);
    assertEquals(customerName, actual.getCustomerName());
    assertEquals(customerID, actual.getCustomerID());
    // and so for for each field
}