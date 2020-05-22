Session session = HibernateUtil.getSessionFactory().getCurrentSession();
Transaction tx = session.beginTransaction();
for(PersistableStatisticItem item:
    session.createQuery("FROM PersistableStatisticItem item").list()) {
    session.delete(item);
}
session.flush();
assert session.createQuery("FROM PersistableStatisticItem item").list().size() == 0;
tx.commit();