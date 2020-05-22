@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestClass {
    @LocalServerPort
    private int port;
    @Test public void someTest() {}
}