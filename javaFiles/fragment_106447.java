Session session = sessionFactory.openSession();
ManagedSessionContext.bind(session);

Transaction tx = session.beginTransaction();

EntityA a = daoA.read();
EntityC c = daoC.read();
a.setFoo(newFoo);
daoA.write(a);
session.flush();
tx.commit();

// This clears the persistenceContext cache and 
// the actionQueue so make sure everything is 
// done before this point.
session.clear(); 

Transaction tx = session.beginTransaction();
c = daoC.read();
tx.commit();

session.close();