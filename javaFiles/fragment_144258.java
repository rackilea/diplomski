package com.mycompany;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.lookup.AbstractLookup;
import org.apache.logging.log4j.core.lookup.StrLookup;

/**
 * Looks up keys from a class SomeClass which has access to all
 * information you want to provide in the log file header at rollover.
 */
@Plugin(name = "setu", category = StrLookup.CATEGORY)
public class SetuLookup extends AbstractLookup {

    /**
     * Looks up the value of the specified key by invoking a
     * static method on SomeClass.
     *
     * @param event The current LogEvent (ignored by this StrLookup).
     * @param key  the key to be looked up, may be null
     * @return The value of the specified key.
     */
    @Override
    public String lookup(final LogEvent event, final String key) {
        return com.mycompany.SomeClass.getValue(key);
    }
}