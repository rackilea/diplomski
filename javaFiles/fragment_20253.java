package GradleEclipseTestProject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GradleLog4jTest {


    public static void main(String[] args) {
        System.out.println("Testing log4j dependencies");
        Logger logger = LogManager.getLogger();
        logger.info("This is a sample logger");
    }

}