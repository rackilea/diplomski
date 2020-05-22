public class Main {
    public static final Logger LOGGER = Logger.getLogger(Main.class);
}

public class AnotherClass {
    public void doSomething() {
        Main.LOGGER.debug("value=" + value);
    }
}