public class CustomerListTest {


        @Test
        public void shouldHaveZeroNumberOfCustomersWhenNewCreated() {
            CustomerList customers = new CustomerList();
            Assert.assertEquals(0, customers.getNumberOfCustomers());
        }

        @Test
        public void shouldIncreaseSizeWhenNewCustomerAdded() {
            CustomerList customers = new CustomerList();
            Customer customer = //valid costumer here;
            customers.add(customer)
            Assert.assertEquals(1, customers.getNumberOfCustomers());
        }

        //and so on...

        @Test
        public void shouldReturnNullWhenFindByIdInvokedWithNotExistId() {
            CustomerList customers = new CustomerList();
            Assert.assertEquals(null, customers.getById(42)); 
            //return null is bad practice better to return Optional<Customer>, Iterator, or Collection
        }

        @Test
        public void shouldReturnCustomerWithIdWhenItPresentsInList() {
            CustomerList customers = new CustomerList();
            Customer customer = new Customer("name", 1, "email", 20);
            customers.add(customer);
            Assert.assertEquals(customer, customers.getById(1)); 
            // this works because not overriden equals checks if it's same instance, 
            //you need to implement equals and hashcode in Customer class
        }

        @Test
        public void shouldReturnNullWhenFindByIdArgumenNotEqualsToStoredCustomersId() {
            CustomerList customers = new CustomerList();
            Customer customer1 = new Customer("name", 1, "email", 20);
            Customer customer2 = new Customer("name", 2, "email", 20);
            Customer customer3 = new Customer("name", 3, "email", 20);
            customers.add(customer1);
            customers.add(customer2);
            customers.add(customer3);
            Assert.assertEquals(null, customers.getById(42)); 
            // this works because not overriden equals checks if it's same instance, 
            //you need to implement equals and hashcode in Customer class
        }

}