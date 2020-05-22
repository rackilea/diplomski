public abstract class AbstractDao extends NamedParameterJdbcDaoSupport {
    @Autowired
    public void setDataSource(DataSource dataSource) {
        super.setDataSource(dataSource);
    }
}

@Component
public class Dao extends AbstractDao {
}