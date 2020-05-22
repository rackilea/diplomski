@Repository
public class MySpringDAO extends MyDAO {

    @AutoWired
    protected SessionFactory sessionFactory;
}