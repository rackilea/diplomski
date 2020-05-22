for(i=0;i<Customer.size();i++)
{
    customerOOS.writeObject(Customer.get(i));
}
for (i = Customer.size(); i < 100; i++) {
    customerOOS.writeObject(null);
}