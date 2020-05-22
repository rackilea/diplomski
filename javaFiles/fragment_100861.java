public class A {
    private byte[] buf;

    public void foo() {
        synchronized (buf) {
            // does something with buf
        }
    }

    public class B {
        public void bar() {
            synchronized (buf) {
                // also does something with buf
            }
        }
    }
}