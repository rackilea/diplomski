public class A {
    private byte[] buf;

    public synchronized void foo() {
        // does something with buf
    }

    public class B {
        public void bar() {
            synchronized (A.this) {
                // also does something with buf
            }
        }
    }
}