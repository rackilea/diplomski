class A {
    Logger LOGGER;

    A(String id) {
        LOGGER = Logger.getLogger(getClass() + "(" + id + ")");
    }

    void myMethod() {
        LOGGER.info("Hello!");
    }
}