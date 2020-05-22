@Test
public void testFindCustomerByCity() {
    Customer customer = new Customer("Max", "Tester");
    customer.addAddress(new Address("Street", "1", "12345", "City"));
    Customer savedCustomer = customerRepository.save(customer);

    Assert.assertTrue(savedCustomer.getId() > 0);

    List<Customer> customerList = customerRepository.findByCity("City");
    Assert.assertThat(customerList.size(), is(1));
}