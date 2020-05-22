package de.scrum_master.aspect;

import java.util.logging.Logger;
import de.scrum_master.app.CustomLoggable;

public aspect LoggableAspect {
    public static interface Loggable {
        Logger getLogger();
        String someOtherMethod(int number);
    }

    declare parents : (@CustomLoggable *) implements Loggable;

    public Logger Loggable.getLogger() {
        return LoggerHolder.aspectOf(this.getClass()).getLogger();
    }

    public String Loggable.someOtherMethod(int number) {
        return ((Integer) number).toString();
    }
}