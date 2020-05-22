try
{
    Configuration cfg =new Configuration();
    cfg.configure("hibernate.cfg.xml");

    SessionFactory sf=cfg.buildSessionFactory();
    Session sess=sf.openSession();
    ----------------------------------
your code
------------------------------

Transaction tx=sess.beginTransaction();
sess.save(e);

tx.commit();

sess.flush();
sess.close();
sf.close();


}
catch(Exception e)
{
System.out.println("e="+e.getMessage());
}