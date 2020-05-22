Session session = factory.openSession();
Transaction tx = session.beginTransaction();

Vendor v = (Vendor)session.get(Vendor.class, 100);

Customer c1 = new Customer();
c1.setCustomerId(502);
c1.setCustomerName("Rajveer");
c1.setParent(v);

Customer c2 = new Customer();
c2.setCustomerId(503);
c2.setCustomerName("Abhishek");
c2.setParent(v);

Set s = new HashSet();
s.add(c1);
s.add(c2);

v.addChildren(s); // Add, not Set, unless you want to delete existing ones

session.saveOrUpdate(v);
tx.commit();
session.close();