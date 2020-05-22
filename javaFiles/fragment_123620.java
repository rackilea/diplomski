public class HelperObject
{
    private SessionFactory factory;
    private Session session;
    private Transaction tx;

    public void init()
    {
        session = factory.createSession();
        tx = session.beginTransaction();
    }

    public void destroy()
    {
        tx.commit();
        session.close();
    }

    ...
}