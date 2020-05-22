Session session = factory.getCurrentSession();//Use getCurrentSession rather than openSession
Transaction trans = session.beginTransaction();
trans.begin();

Session session2 = factory.getCurrentSession();//Same session will be returned.

System.out.println(session2.isConnected());
trans.commit();