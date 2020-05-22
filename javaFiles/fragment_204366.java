RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class, WebSecurityConfig.class, MvcWebApplicationInitializer.class},
loader = AnnotationConfigContextLoader.class)
@PersistenceContext
@Transactional(transactionManager = "hibernateTransactionManager")
public class NewsDaoTest {