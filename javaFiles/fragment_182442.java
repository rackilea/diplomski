@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/integration-context.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class RepositoryTest extends AbstractTransactionalJUnit4SpringContextTests{
    @Autowired
    private IRepository repository;          

    @Test
    public void testRepositoryPersistence() {
        Op op = mock(Op.class);

        repository.save(op);
    }
}