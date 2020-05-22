public class MyClass {

    long version;
    long field;
    Runnable methodRunnable;

    public MyClass(long version) {
        this.version = version;

        if (version == 4) {
            field = 10; // Example
            methodRunnable = new Runnable() {
                @Override
                public void run() {
                    // ... Implementation here...
                }
            };
        } else {
            field = 5;
            methodRunnable = new Runnable() {
                @Override
                public void run() {
                    // Implement here...
                }
            };
        }
    }

    public void method() {
        methodRunnable.run();
    }
}