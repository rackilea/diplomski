//in DAO create logic
Session session = sessionFactory.getCurrentSession(); //or openSession()
Address office = new Address();
Address home = new Address();
Address secondary = new Address();
//populate Address objects...
session.saveOrUpdate(office);
session.saveOrUpdate(home);
session.saveOrUpdate(secondary);
Customer customer = new Customer();
//populate Customer object...
customer.setOfficeAddress(office);
customer.setHomeAddress(home);
customer.setSecondaryAddress(secondary);
session.saveOrUpdate(customer);