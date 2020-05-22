Controller testCntlr;
/**
 * @throws java.lang.Exception
 */
@Before
public void setUp() throws Exception {
    testCntlr = Controller.getInstance() ;
}

/**
 * @throws java.lang.Exception
 */
@After
public void tearDown() throws Exception {
    testCntlr = null;
}