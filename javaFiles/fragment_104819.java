public interface SomeService{
}

@Primary
@Service(value = "jdbcService")
public class  JdbcService extends SomeService{
   @Autowired
   private Repo repo;
}

@Service(value = "hibernateService")
public class  HibernateService extends SomeService{
   @Autowired
   @Qualifier("hibernateRepo")
   private Repo repo;
}