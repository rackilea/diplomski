package de.scrum_master.app;

public class Connector {
    public void getStart(String s1) {
        Handler h = new Handler(s1);
        h.run();
    }
}