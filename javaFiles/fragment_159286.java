package de.scrum_master.app;

public class App {
    public static void main(String[] args) throws InterruptedException {
        // The aspect should ignore this thread
        new Handler("foo").start();
        // Wait a little while so as not to mess up log output
        Thread.sleep(250);
        new Connector().getStart("testtest");
    }
}