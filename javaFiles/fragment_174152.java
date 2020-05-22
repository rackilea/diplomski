@Before
public void setUp() throws Exception
{
    logger.info("Performing the setup of test {}", testName.getMethodName());
    em = emf.createEntityManager();
    // Starts the transaction before every test
    em.getTransaction.begin();
}

@After
public void tearDown() throws Exception
{
    logger.info("Performing the teardown of test {}", testName.getMethodName());
    if (em != null)
    {
        // Rolls back the transaction after every test
        em.getTransaction().rollback();
        em.close();
    }
}