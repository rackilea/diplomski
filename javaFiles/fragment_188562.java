package sample;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

import org.apache.commons.lang.StringUtils;

public class stackoverflow11937181 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Logger rootLogger = Logger.getLogger("");
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String logDirectory = System.getProperty("log_directory");
        String logFile = (logDirectory == null ? StringUtils.EMPTY : logDirectory) + "/myapp_" + date + "_%u.log";
        try {
            FileHandler logHandler = new FileHandler(logFile, 524288000, // 500 MB max size
                    1, // one log file at a time
                    true // if it exists: append, don't overwrite
            );
            Level defaultLevel = Level.INFO;
            logHandler.setFormatter(new XMLFormatter());
            logHandler.setLevel(java.util.logging.Level.FINE);
            for (Handler h : rootLogger.getHandlers()) {
                rootLogger.removeHandler(h);
            }
            rootLogger.setLevel(defaultLevel);
            rootLogger.addHandler(logHandler);

        }
        catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        rootLogger.log(Level.FINE, "sample");

    }

}