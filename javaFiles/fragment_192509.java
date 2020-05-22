import com.foo.Bar;

 // Import log4j classes.
 import org.apache.log4j.Logger;
 import org.apache.log4j.BasicConfigurator;

 public class MyApp {

   // Define a static logger variable so that it references the
   // Logger instance named "MyApp".
   static Logger logger = Logger.getLogger(MyApp.class);

   public static void main(String[] args) {

     // Set up a simple configuration that logs on the console.
     BasicConfigurator.configure();

     logger.info("Entering application.");
     Bar bar = new Bar();
     bar.doIt();
     logger.info("Exiting application.");
   }
 }