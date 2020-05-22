import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.*;

public class ClassLogger {

  private Logger logger;
  private FileHandler fh;

  public ClassLogger(String classname){

    this.logger = Logger.getLogger(classname);

    try {
      String path = "/Users/myUser/Workspace/stackoverflow/test/src/main/java/logging.properties";
      FileInputStream configFile = new FileInputStream(path);
      LogManager.getLogManager().readConfiguration(configFile);
    } catch (IOException ex) {
      ex.printStackTrace();
    }

    try {
      String directory = "/Users/myUser/Workspace/stackoverflow/test/src/main/java/";
      String filename = "try.log";
      this.fh = new FileHandler(directory+filename);
    } catch (IOException ex1) {
      ex1.printStackTrace();
    }

    //add handler
    logger.addHandler(fh);
  }

  public void error(String msg) { logger.severe(msg);}
  public void warning(String msg) { logger.warning(msg); }
  public void info(String msg) { logger.info(msg); }
  public void debug(String msg) { logger.fine(msg); }

  public static void main(String[] args) {
    ClassLogger log = new ClassLogger(ClassLogger.class.getName());
    log.warning("attention please");
    log.error("error");
    log.debug("dddd");
    log.info("info");
  }
}