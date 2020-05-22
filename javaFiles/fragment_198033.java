import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

public class Test {

    public static void main(String[] args) {
        PatternLayout pl = new PatternLayout("[%-5p] %C.%M:%L: %m%n");
        ConsoleAppender appender = new ConsoleAppender(pl);
        Logger.getRootLogger().addAppender(appender);
        // The rest of your code...
    }
}