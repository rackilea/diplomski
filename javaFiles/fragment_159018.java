package com.example.pushvaadinapp;

import java.time.Instant;
import java.util.Random;
import java.util.UUID;

/**
 * Access database to check for fresh data. If fresh data is found, package for
 * delivery. Actually we generate random data as a way to mock database access.
 *
 * @author Basil Bourque
 */
public class DataProvider
{

    // Statics
    private static final DataProvider singleton = new DataProvider();

    // Member vars.
    private DataEvent cachedDataEvent = null;
    private Instant whenLastChecked = null; // When did we last check for fresh data.

    // Other vars.
    private final Random random = new Random();
    private Integer minimum = Integer.valueOf( 1 ); // Pick a random number between 1 and 999.
    private Integer maximum = Integer.valueOf( 999 );

    // Constructor. Private, for simple Singleton pattern.
    private DataProvider ()
    {
        System.out.println( Instant.now().toString() + " Method DataProvider::constructor running." );   // DEBUG logging.
    }

    // Singleton accessor.
    public static DataProvider instance ()
    {
        System.out.println( Instant.now().toString() + " Method DataProvider::instance running." );   // DEBUG logging.
        return singleton;
    }

    public Boolean checkForFreshData ()
    {
        System.out.println( Instant.now().toString() + " Method DataProvider::checkForFreshData running." );   // DEBUG logging.

        synchronized ( this ) {
            // Record when we last checked for fresh data.
            this.whenLastChecked = Instant.now();

            // Mock database access by generating random data.
            UUID dbUuid = java.util.UUID.randomUUID();
            Number dbNumber = this.random.nextInt( ( this.maximum - this.minimum ) + 1 ) + this.minimum;
            Instant dbUpdated = Instant.now();

            // If we have no previous data (first retrieval from database) OR If the retrieved data is different than previous data --> Fresh.
            Boolean isFreshData = ( ( this.cachedDataEvent == null ) ||  ! this.cachedDataEvent.uuid.equals( dbUuid ) );

            if ( isFreshData ) {
                DataEvent freshDataEvent = new DataEvent( dbUuid , dbNumber , dbUpdated );
                // Post fresh data to event bus.
                this.cachedDataEvent = freshDataEvent; // Remember this fresh data for future comparisons.
            }

            return isFreshData;
        }
    }

    public DataEvent data ()
    {
        System.out.println( Instant.now().toString() + " Method DataProvider::data running." );   // DEBUG logging.

        synchronized ( this ) {
            return this.cachedDataEvent;
        }
    }

}