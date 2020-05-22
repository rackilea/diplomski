@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:ApplicationContext.xml" })
public class HibernateSessionInEntityManagerTest {

    @Autowired
    public SessionFactory sessionFactory;

    @Test
    @Transactional
    public void testGetHibernateSession(){
        Session session = sessionFactory.getCurrentSession();
        Assert.assertNotNull(session);
    }
}