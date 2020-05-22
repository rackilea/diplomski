import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ApplicationConfiguration implements ServletContextListener{

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {

        try {
            // step-1 : set hostName into System's property, which will use by log4j
            System.setProperty("hostName", InetAddress.getLocalHost().getHostName());
            //step - 2 : set currentDate into System's property, which will use by log4j
            System.setProperty("currentDate", new SimpleDateFormat("dd-MMM-yyyy").format(new Date()));
        } catch (UnknownHostException e) {
            System.out.println("Error Message : " + e.getMessage());
            //e.printStackTrace();
        } 


    }


}