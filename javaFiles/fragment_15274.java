public class Log4jTest {
  // Initialize logger for instance Log4jTest
  static Logger log  = Logger.getLogger(Log4jTest.class);

  public static void main (String[] args) {
     // Basic configurator to log debug messages to the console
     BasicConfigurator.configure();         

     // Add some log messages
     log.debug("This is a debug message");
     log.trace("This is a trace message");         
 }
}