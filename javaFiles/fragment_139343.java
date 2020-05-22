public class Main {
    private static final Logger LOGGER = Logger.getLogger("GLOBAL");
}

public class AnotherClass {
    private final Logger LOGGER = Logger.getLogger("GLOBAL");

    public void doSomething() {
        LOGGER.debug("value=" + value);
    }
}