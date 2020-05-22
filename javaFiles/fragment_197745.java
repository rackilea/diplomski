import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Controller {
    Logger logger = LoggerFactory.getLogger(Controller.class);

    public void log() { logger.warn("yup"); }
}