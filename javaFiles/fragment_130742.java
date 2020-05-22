package Logger;
    import static Logger.LoggerClass.logger;
    import java.io.IOException;
    import java.util.logging.Level;

    //There are better ways to do this.
    static {
       new LoggerClass();
    }

    public class LoggingTest {



    public static void main(String[] args) throws IOException {

        try
    {
      ((Object) null).toString();
    }
    catch ( Exception e )
    {
      logger.log( Level.SEVERE, "oh oh", e );
    }

    logger.info( "Hat funktioniert" );
  }
    }