import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

    @BeforeAll
    static void setup() {
        Logger root = (Logger) LoggerFactory.getLogger("uk.co.jemos.podam.api");
        root.setLevel(Level.OFF);
    }