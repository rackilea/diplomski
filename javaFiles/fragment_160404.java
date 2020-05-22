package com.example.pushvaadinapp;

import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import javax.servlet.annotation.WebServlet;

/**
 * © 2014 Basil Bourque. This source code may be used freely forever by anyone absolving me of any and all responsibility.
 *
 *  +----------------------------+
 *  |  NOT FOR PRODUCTION USE!   |
 *  +----------------------------+
 *     Sleeping threads is an awkward way to manage scheduled background work.
 *     By the way, never use a 'Timer' in a Servlet environment. 
 *     Use an Executor instead, probably a ScheduledExecutorService.
 */
@Push
@Theme ( "mytheme" )
@Widgetset ( "com.example.pushvaadinapp.MyAppWidgetset" )
public class MyUI extends UI
{

    Label label = new Label( "Now : " );

    @Override
    protected void init ( VaadinRequest vaadinRequest )
    {
        // Put a widget on this UI. In real work we would use a Layout.
        setContent( this.label );

        // Start the data feed thread
        new FeederThread().start();
    }

    @WebServlet ( urlPatterns = "/*" , name = "MyUIServlet" , asyncSupported = true )
    @VaadinServletConfiguration ( ui = MyUI.class , productionMode = false )
    public static class MyUIServlet extends VaadinServlet
    {
    }

    public void tellTime ()
    {
        label.setValue( "Now : " + new java.util.Date() ); // If Java 8, use: Instant.now(). Or, in Joda-Time: DateTime.now().
    }

    class FeederThread extends Thread
    {

        int count = 0;

        @Override
        public void run ()
        {
            try {
                // Update the data for a while
                while ( count < 100 ) {
                    Thread.sleep( 1000 );

                    // Calling special 'access' method on UI object, for inter-thread communication.
                    access( new Runnable()
                    {
                        @Override
                        public void run ()
                        {
                            count ++;
                            tellTime();
                        }
                    } );
                }

                // Inform that we have stopped running
                // Calling special 'access' method on UI object, for inter-thread communication.
                access( new Runnable()
                {
                    @Override
                    public void run ()
                    {
                        label.setValue( "Done." );
                    }
                } );
            } catch ( InterruptedException e ) {
                e.printStackTrace();
            }
        }
    }
}