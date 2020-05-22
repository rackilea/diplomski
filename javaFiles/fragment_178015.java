@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class, CachingConfig.class }, loader = AnnotationConfigContextLoader.class)
@PersistenceContext
@Transactional("hibernateTransactionManager")
public class EHCacheTest extends AbstractTransactionalJUnit4SpringContextTests {
}