@RunWith(PowerMockRunner.class)
@PrepareForTest(DaoLoader.class)
@PowerMockIgnore({"javax.persistence.*","mypackage.beans.*"})
public class UserParserTest {

private static EntityManagerFactory emf;
private UserParser parser;
private UserDao dao;
private EntityManager em;

@BeforeClass
public static void initializeEMF(){
    emf = Persistence.createEntityManagerFactory("testing");
}

@AfterClass
public static void closeEntityManagerFactory() {
    emf.close();
}

@Before
public void setUp() throws Exception {
    em = emf.createEntityManager();
    em.getTransaction().begin();
    dao = new UserDao(em);
    PowerMock.mockStatic(DaoLoader.class);
    EasyMock.expect(DaoLoader.loadDao("java:module/UserDao")).andReturn(dao);

    PowerMock.replay(DaoLoader.class);

    parser = new UserParser();
}

@After
public void rollbackTransaction() {
    if (em.getTransaction().isActive()) {
        em.getTransaction().rollback();
    }

    if (em.isOpen()) {
        em.close();
    }

    PowerMock.verify(DaoLoader.class);
}

@Test
public void testParse() throws Exception {
    parser.parse("test_username");
}