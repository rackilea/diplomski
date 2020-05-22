public class PersistenceTest {

    private static SessionFactory sessionFactory;

    private Serializable id;

    @BeforeClass
    public static void setUpClass() {
        Configuration c = new Configuration();
        c.addResource("mapping.hbm.3589013.xml");

        sessionFactory = c.configure().buildSessionFactory();
    }

    @Before
    public void setUp() throws Exception {
        SpreadsheetImportTemplate sit = new SpreadsheetImportTemplate();
        sit.addColumn(new SpreadsheetImportTemplateColumn());

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        id = session.save(sit);

        session.getTransaction().commit();
    }

    @Test
    public void removedOrphan() throws Exception {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<SpreadsheetImportTemplateColumn> sitcList = session.createQuery("from SpreadsheetImportTemplateColumn").list();

        assertTrue(sitcList.size() == 1);

        SpreadsheetImportTemplate sit = (SpreadsheetImportTemplate) session.get(SpreadsheetImportTemplate.class, id);
        sit.getColumns().remove(sitcList.get(0));

        session.getTransaction().commit();

        assertTrue(sit.getColumns().size() == 0);
    }

}