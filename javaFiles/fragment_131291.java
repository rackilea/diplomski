public class ChangeEntryTest {
    private static EntityManagerFactory emf;    
    private EntityManager em;

    @BeforeClass
    public static void createEntityManagerFactory() {
        emf = Persistence.createEntityManagerFactory("TestPu");
    }    
    @AfterClass
    public static void closeEntityManagerFactory() {
        emf.close();
    }    
    @Before
    public void beginTransaction() {
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }    
    @After
    public void rollbackTransaction() {   
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
        if (em.isOpen()) {
            em.close();
        }
    }

    @Test 
    public void testCreateEntryWithoutDetails() {
        try {
            ChangeEntry entry = new ChangeEntry();
            em.persist(entry);
            fail("Expected ConstraintViolationException wasn't thrown.");
        } catch (ConstraintViolationException e) {
            assertEquals(1, e.getConstraintViolations().size());
            ConstraintViolation<?> violation = e.getConstraintViolations()
                .iterator().next();

            assertEquals("changeEntryDetails", violation.getPropertyPath()
                .toString());
            assertEquals(NotNull.class, violation.getConstraintDescriptor()
                .getAnnotation().annotationType());
        }
    }

    @Test
    public void testCreateDetailsWithoutEntry() {    
        try {
            ChangeEntryDetails details = new ChangeEntryDetails();
            em.persist(details);
            fail("Expected ConstraintViolationException wasn't thrown.");
        } catch (ConstraintViolationException e) {
            assertEquals(1, e.getConstraintViolations().size());
            ConstraintViolation<?> violation = e.getConstraintViolations()
                .iterator().next();

            assertEquals("changeEntry", violation.getPropertyPath()
                .toString());
            assertEquals(NotNull.class, violation.getConstraintDescriptor()
                .getAnnotation().annotationType());
        }
    }

    @Test
    public void validEntryWithDetails() {
        ChangeEntry entry = new ChangeEntry();
        ChangeEntryDetails details = new ChangeEntryDetails();
        entry.addDetails(details);
        em.persist(entry);

        Query query = em.createNamedQuery(ChangeEntry.FIND_ALL_CHANGEENTRIES);
        assertEquals(1, query.getResultList().size());
    }
}