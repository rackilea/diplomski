import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyClass {

  private static final Logger LOGGER = LoggerFactory.getLogger(Myclass.class);

  public void method() {
    try {
      ...
    } catch (IOException ex) {
      LOGGER.error("method failed to do what was expected: {}", ex);
      throw ex;
    }