public class CustomLogging 
{
static private FileHandler txtFileHandle;
static private SimpleFormatter formatterTxt;

static public Logger getLogger(Class loggerClass) throws IOException 
{
    //Global logger configuration
    Logger logger = Logger.getLogger(loggerClass);

    logger.setLevel(Level.INFO);
    txtFileHandle = new FileHandler("Logging.txt");

    formatterTxt = new SimpleFormatter();
    txtFileHandle.setFormatter(formatterTxt);
    logger.addHandler(txtFileHandle);

    return logger;
}

 static public void shutdown() throws IOException
 {
    txtFileHandle.close();
 }
}