Session session = Hibernate.util.HibernateUtil.getSessionFactory().openSession();
session.beginTransaction();
String sql = String.format("INSERT INTO products (name,cost) VALUES('%s',%s);",product.getName(), product.getCost());
session.createSQLQuery(sql).executeUpdate();
session.getTransaction().commit();
session.close();