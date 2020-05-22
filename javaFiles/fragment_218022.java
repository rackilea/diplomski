public class ApplicationTest {
    @Test
    public void simpleCheck() {
        running(fakeApplication(), new Runnable() {
            public void run() {
                int a = 1 + 1;
                assertThat(a).isEqualTo(2);
            }
        });
    }
}