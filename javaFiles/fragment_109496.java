public class FakeTest {

    public static class Foo {
        public void doSomething() {
            try {
                Bar b = new Bar(73);
            } catch (Throwable t) {
                System.out.println("Got a " + t.getClass());
            }
        }
    }

    public static class Bar {
        private Integer param;
        public Bar(Integer parameter) {
            System.out.println("Got a real bar with param " + parameter); 
            this.param = parameter;
        }
    }

    public static class MockBar extends MockUp<Bar> {
        public int error = 4;

        @Mock
        public void $init(Integer parameter) {
            System.out.println("Initing fake with parameter " + parameter);
            if (error==1) {
                throw new IllegalAccessError();
            }
        }
    }

    @Test
    public void fakeTest() throws Exception {
        System.out.println("Testing...");
        MockBar mb = new MockBar();
        mb.error=1;

        Foo f = new Foo();
        f.doSomething();
    }
}