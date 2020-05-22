// Single reference.
customerlist.get(0).getCustomerName();

// Or...
Customer c = customerlist.get(0);
c.getCustomerName();

// Or looping.
for (Customer c : customerList) {
    c.getCustomerName();
}