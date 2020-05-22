@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/fooService.xml")
public class FooServiceTests {

    private @Autowired TransactionManager transactionManager;
    private @Autowired FooService fooService;

    @Test
    public void testProvideService() {
        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
        fooService.provideService();
        transactionManager.rollback(status);
        // assert repository values are unchanged ... 
}