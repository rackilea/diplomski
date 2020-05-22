public class HelloWorldUnmanagedExtensionApiTest extends WrappingServerIntegrationTest {

    @Override
    protected Map<String, String> thirdPartyJaxRsPackageMappings() {
        return Collections.singletonMap("com.graphaware.example.unmanaged", "/ext");
    }

    @Test
    public void shouldCreateAndReturnNode() {
        String result = TestUtils.post(baseNeoUrl() + "/ext/helloworld/create", 200);
        assertEquals("0", result);

        GraphUnit.assertSameGraph(getDatabase(), "CREATE (:HelloWorld {hello:'world'})");
    }
}