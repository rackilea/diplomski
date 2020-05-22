try (Session session = ourSessionFactory.openSession()) {
    try {
       tx = session.beginTransaction();
       Person p = new Person(name, affiliation);
       personID = (Integer) session.save(p);
       tx.commit();
    }
    catch (HibernateException e) {
        if (tx != null) {
             tx.rollback();
        }
    }
}