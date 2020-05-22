public class Foobar {
    final static Logger log = LoggerFactory.getLogger(Foobar.class);

    public Foobar() {
        /* Log to foo_bar_file.log in jboss server log dir. */
        log.info("Foobar log example.");
    }
}