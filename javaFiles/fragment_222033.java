package de.scrum_master.aspect;

import java.util.logging.Logger;
import de.scrum_master.app.CustomLoggable;

public aspect LoggerHolder
    pertypewithin(@CustomLoggable *)
{
    private Logger logger;

    after() : staticinitialization(*) {
        logger = Logger.getLogger(getWithinTypeName());
    }

    public Logger getLogger() {
        return logger;
    }
}