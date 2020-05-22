package com.example.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        String[] skills = {"PHP", "Java", "MySQL", "JavaScript", "jQuery", "Node.js"};
        event.getServletContext().setAttribute("skills", skills);
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {

    }
}