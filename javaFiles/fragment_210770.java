public class CustomerManager {

    private CustomerDAO customerDAO;

    @Autowired
    public CustomerManager(@Qualifier("customerDAO") CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }
}

public class CustomerManagerUnitTest {

    public void testFindCustomers_OneResult() {
        CustomerDAO mockCustomerDAO = ...;
        CustomerManager customerManager = new CustomerManager(mockCustomerDAO);

        expect(customerDAO.findCustomers()).andReturn(...);
        // ...
        List<Customer> customers = customerManager.findCustomers();

        // Test...
    }
}