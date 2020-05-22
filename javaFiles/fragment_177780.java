@Test
public void test() {
    Thread t = new Thread(() -> {throw new RuntimeException("Hi!");});

    t.setUncaughtExceptionHandler((thread, throwable) -> System.err.println("Error!"));

    t.start();//it'll print Error!
}