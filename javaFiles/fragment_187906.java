//in DAO update logic
Session session = sessionFactory.getCurrentSession(); //or openSession()
Customer customer = (Customer) session.get(Customer.class, customerId);
Address address = (Address) session.get(Address.class, addressId);
customer.setOfficeAddress(address);
session.saveOrUpdate(customer); //updates officeAddressId column to value of addressId