@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/spring/app-context.xml" })
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
@Transactional
public class UserDAOTest extends AbstractTransactionalJUnit4SpringContextTests  {

    @Autowired
    private IUserDAO userDAO;

    public void setUserDAO(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Test
    public void testGetUser() throws Exception {
        User user = userDAO.get(2);
        assertNotNull(user);
    }
}