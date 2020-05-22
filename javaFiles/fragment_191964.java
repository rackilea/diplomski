//sessionFactory = getHibernateTemplate().getSessionFactory();
Session session = getSessionFactory().getCurrentSession();
Query query = session.createQuery("select value from table where ...");
query.setParameters("param1", value1);
result = (Type) query.uniqueResult(); //The type is you desired result type.
//test for null here if needed