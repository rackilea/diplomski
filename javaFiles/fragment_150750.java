public class MySingletonDAO {
    private static MySingletonDAO INSTANCE = new MySingletonDAO();
    public static MySingletonDAO getInstance() { return INSTANCE;}

    private MySingletonDAO() {
    }

    public List<Stuff> getAllTheStuff() {
        Session session = HibernateUtil.currentSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("FROM StuffDBTable");
            session.getTransaction().commit();
            return (List<Stuff>) q.list();
        }
    }
}