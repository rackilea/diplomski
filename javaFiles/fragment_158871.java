public class AbstractITest {

    @Before
    public void setUp() throws Exception {
        //
        // drop and recreate tables here if needed; we use 
        // Spring's SimpleJdbcTemplate executing drop/create SQL
        //
        IDataSet masterDataSet = new FlatXmlDataSetBuilder().build("file://masterDataSet.xml");
        DatabaseOperation.CLEAN_INSERT.execute(dbUnitConnection, dataSet);
    }
}

public class AbstractModuleITest extends AbstractITest {

    @Before
    public void setUp() throws Exception {
        super.setUp();
        IDataSet moduleDataSet = new FlatXmlDataSetBuilder().build("file://moduleDataSet.xml");
        DatabaseOperation.CLEAN_INSERT.execute(dbUnitConnection, moduleDataSet);
    }
}

public class SomeITest extends AbstractModuleITest {
    // The "setUp()" routine only here if needed, remember to call super.setUp().

    @Test
    public void someTest() { ... }
}