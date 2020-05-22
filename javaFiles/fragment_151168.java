package com.example
public class MySessionListener implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent event) {
        System.out.println("Session created");
    }

    public void sessionDestroyed(HttpSessionEvent event) {
        System.out.println("Session destroyed");
    }
}