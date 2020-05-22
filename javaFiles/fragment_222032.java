package de.scrum_master.app;

import java.util.logging.Level;

@CustomLoggable
public class AnnotatedClass {
    public void doSomething() {
        getLogger().log(Level.INFO, "Logging some action via ITD logger");
        getLogger().log(Level.INFO, someOtherMethod(11));
    }
}