Session session = factory.getCurrentSession();
Transaction tx = session.beginTransaction();

Product p = new Product();
session.persist(p);
session.flush();
System.out.println(session.isOpen()); // prints true

p.setName("foo");
session.merge(p);
tx.commit();
System.out.println(session.isOpen()); // prints false