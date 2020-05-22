@Service
public class TableOneDaoImpl extends HibernateDaoSupport implements TableOneDao  {

    @Override
    public void save(TableOne tableOne) throws Exception {
        Session session = null;
        try {
            session = getSessionFactory().openSession();

            session.save(tableOne);
            session.flush();
        } catch (Exception e) {
            throw new Exception("Could not save tableOne!", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

}