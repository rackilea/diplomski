private CustomerDao customerDao;

    private Addressdao addressDao;

    private int customerId;

    public void updateCustomerWithAddress(){
        Address address = new Address();
        //init address variables

        addressDao.insert(address);  

        Customer customer = customerDao.find(customerId); 

        //I assume you have a bidirectional oneToOne mapping between address and customer
        address.setCustomer(customer);
        customer.setAddress(address);

        customerDao.update(customer);      
    }