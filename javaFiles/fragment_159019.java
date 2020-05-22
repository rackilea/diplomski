package com.example.pushvaadinapp;

import java.time.Instant;
import java.util.UUID;

/**
 * Holds data to be published in the UI. In real life, this could be one object
 * or could hold a collection of data objects as might be needed by a chart for
 * example. These objects will be dispatched to subscribers of an MBassador
 * event bus.
 *
 * @author Basil Bourque
 */
public class DataEvent
{

    // Core data values.
    UUID uuid = null;
    Number number = null;
    Instant updated = null;

    // Constructor
    public DataEvent ( UUID uuid , Number number , Instant updated )
    {
        this.uuid = uuid;
        this.number = number;
        this.updated = updated;
    }

    @Override
    public String toString ()
    {
        return "DataEvent{ " + "uuid=" + uuid + " | number=" + number + " | updated=" + updated + " }";
    }

}