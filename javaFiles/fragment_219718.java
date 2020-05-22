public class SomeIntegrationTest {
    @Rule
    public DbConnectionRessource dbConnectionResource = new DbConnectionRessource();

    // ...

    @Test
    public void test01() {
        cleanupData(dbConnectionResource.getConnection(), id);
        // do stuff...
    }

    // ...
}