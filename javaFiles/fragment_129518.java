Root root = (Root) unmarshaller.unmarshal(file);
CustomerType orderT = new CustomerType();
Customers cust = new Customers();
for (CustomerType cT : cust.getCustomer()) {
    System.out.println(cT.getContactName());
}