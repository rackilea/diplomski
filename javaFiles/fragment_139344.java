public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class);
    public static final main(String[] args) {
        LOGGER.debug("started");
    }
}

public class AnotherClass {
    private final Logger LOGGER = Logger.getLogger(this.getClass());

    public void doSomething() {
        LOGGER.debug("value=" + value);
    }
}