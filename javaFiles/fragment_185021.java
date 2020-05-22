import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class HelloExample {

static { 
    String filePath=readFile();
    System.setProperty("my.log", filePath); }

final static Logger logger = Logger.getLogger(HelloExample.class);

    public static void main(String[] args) {

        HelloExample obj = new HelloExample();
        obj.runMe("myRun");

    }

    private void runMe(String parameter){

        if(logger.isDebugEnabled()){
            logger.debug("This is debug : " + parameter);
        }

        if(logger.isInfoEnabled()){
            logger.info("This is info : " + parameter);
        }

        logger.warn("This is warn : " + parameter);
        logger.error("This is error : " + parameter);
        logger.fatal("This is fatal : " + parameter);

    }

    public static String readFile()
    {
        Properties prop = new Properties();
        InputStream input = null;

        try {
            //load file from classpath
            input=   HelloExample.class.getClassLoader().getResourceAsStream("config.properties");

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            return prop.getProperty("FILE_PATH");

        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

}