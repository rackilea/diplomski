package com.example.amazingapp;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * @author Basil Bourque
 */
@WebListener
public class WebAppListener implements ServletContextListener {

    @Override
    public void contextInitialized ( ServletContextEvent sce ) {
        System.out.println ( "My Vaadin web app is starting. " );
    }

    @Override
    public void contextDestroyed ( ServletContextEvent sce ) {
        System.out.println ( "My Vaadin web app is shutting down." );
    }

}