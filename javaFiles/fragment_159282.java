package de.scrum_master.app;

public class Plain {
    public void getValue(String s1) {
        System.out.println("Plain getValue: " + s1);
        new Exception().printStackTrace(System.out);
    }
}