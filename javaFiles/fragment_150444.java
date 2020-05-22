public class MyListTest {
    private MyList<String> list;

    @Test
    public void testThreading() {
        AnnotatedTestRunner runner = new AnnotatedTestRunner();
        // Run all Weaver tests in this class, using MyList as the Class Under Test.
        runner.runTests(this.getClass(), MyList.class);
    }

    @ThreadedBefore
    public void before() {
        list = new MyList<>();
    }

    @ThreadedMain
    public void mainThread() {
        list.putIfAbsent("A");
    }

    @ThreadedSecondary
    public void secondThread() {
        list.putIfAbsent("A");
    }

    @ThreadedAfter
    public void after() {
        assertThat(list).hasSize(1);
    }
}