public class WatchTest {
    @Rule
    public TestRule watcher = new TestWatcher() {
        @Override
        protected void succeeded(Description description) {
            System.out.println("Pass!");
        }

        @Override
        protected void failed(Throwable e, Description description) {
            System.out.println("Fail!");
        }
    };

    @Test
    public void testRun() throws Exception {
        String expected = "asd";
        String actual = "qwert";

        assertEquals(expected, actual);
    }
}