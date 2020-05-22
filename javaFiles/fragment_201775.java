SessionFactory sf = HibernateUtil.getSessionFactory();
Session session = sf.openSession();
session.beginTransaction();

Application app1 = new Application();
Application app2 = new Application();
Computer comp = new Computer();
comp.getApplications().add(app1);
comp.getApplications().add(app2);
session.saveOrUpdate(comp);

session.getTransaction().commit();
session.close();