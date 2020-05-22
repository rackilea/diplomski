package com.example.pushvaadinapp;

import java.time.Instant;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Reacts to this web app starting/deploying and shutting down.
 *
 * @author Basil Bourque
 */
@WebListener
public class WebAppListener implements ServletContextListener
{

    ScheduledExecutorService scheduledExecutorService;
    ScheduledFuture<?> dataPublishHandle;

    // Constructor.
    public WebAppListener ()
    {
        this.scheduledExecutorService = Executors.newScheduledThreadPool( 7 );
    }

    // Our web app (Vaadin app) is starting up.
    public void contextInitialized ( ServletContextEvent servletContextEvent )
    {
        System.out.println( Instant.now().toString() + " Method WebAppListener::contextInitialized running." );  // DEBUG logging.

        // In this example, we do not need the ServletContex. But FYI, you may find it useful.
        ServletContext ctx = servletContextEvent.getServletContext();
        System.out.println( "Web app context initialized." );   // INFO logging.
        System.out.println( "TRACE Servlet Context Name : " + ctx.getServletContextName() );
        System.out.println( "TRACE Server Info : " + ctx.getServerInfo() );

        // Schedule the periodic publishing of fresh data. Pass an anonymous Runnable using the Lambda syntax of Java 8.
        this.dataPublishHandle = this.scheduledExecutorService.scheduleAtFixedRate( () -> {
            System.out.println( Instant.now().toString() + " Method WebAppListener::contextDestroyed->Runnable running. ------------------------------" ); // DEBUG logging.
            DataPublisher.instance().publishIfReady();
        } , 5 , 5 , TimeUnit.SECONDS );
    }

    // Our web app (Vaadin app) is shutting down.
    public void contextDestroyed ( ServletContextEvent servletContextEvent )
    {
        System.out.println( Instant.now().toString() + " Method WebAppListener::contextDestroyed running." ); // DEBUG logging.

        System.out.println( "Web app context destroyed." );  // INFO logging.
        this.scheduledExecutorService.shutdown();
    }

}