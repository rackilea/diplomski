package mypackage;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Date;


public class MyHttpSessionListener implements HttpSessionListener
{
    public void sessionCreated(HttpSessionEvent se)
    {
           // DO CREATION LOGIC
    }

    public void sessionDestroyed(HttpSessionEvent se)
    {

             HttpSession session = se.getSession();
           // PERFORM DELETION LOGIC
    }
}