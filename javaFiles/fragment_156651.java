Session s = sessionfactory.openSession();
Transaction tx = null;
try {
tx = s.beginTransaction();
// Your data manipulation here
tx.commit();
} catch (Exception e) {
if (tx != null) { tx.rollback();}
} finally {
s.close();
}