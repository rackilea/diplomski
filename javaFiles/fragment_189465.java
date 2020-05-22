public class SettlementDaoTest extends UnitilsJUnit4{

    @HibernateSessionFactory("test_hibernate.cfg.xml")
    SessionFactory hsfLocal;

    @Before
    public void before(){
        SessionFactoryProvider.setSessionFactory(hsfLocal);
    }

    @Test
    @DataSet
    public void testGetTransaction() throws Exception {


        SessionFactoryProvider.getSessionFactory().getCurrentSession().beginTransaction();

        List<Long> customerIds = Factory.getAtFileSettlementDao().getCustomerIds("TB01");
        Assert.assertNotNull(customerIds);
        Assert.assertEquals(4924L , (long)customerIds.get(0));
        SessionFactoryProvider.getSessionFactory().getCurrentSession().getTransaction().commit();


    }
}