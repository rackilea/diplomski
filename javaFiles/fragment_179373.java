Session sess = factory.openSession();
Transaction tx = null;
// try catch 
tx = sess.beginTransaction();
findByUserId(userId);
tx.commit();
tx.rollBack();