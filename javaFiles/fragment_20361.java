public static Customer merge(Customer first, Customer second) {
        Customer customer = new Customer(first.getName(), first.getTotal(), first.getBalance());
        customer.setTotal(customer.getTotal() + second.getTotal());
        customer.setBalance(customer.getBalance() + second.getBalance());
        return customer;
}