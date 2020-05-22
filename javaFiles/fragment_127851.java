package com.myproject;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ApplicationListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        System.out.println(" Server Starting !!!!!! ");

        //Any other code you can place here
    }

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        System.out.println(" Server Shutting down !!!!!! ");
    }
}