public interface SomeInterface {
    Logger log = LoggerFactory.getLogger(SomIface.class);

    default void action() {
        log.info("TEST");
    }
}