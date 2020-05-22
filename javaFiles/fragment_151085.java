@Component
public class TestConfig {

@Autowired
@Qualifier(value="firstSessionFactory")
private SessionFactory sessionFactory;

@Autowired
@Qualifier(value="secondSessionFactory")
private SessionFactory secondDBSessionFactory;

//...

}