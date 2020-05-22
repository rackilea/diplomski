package com.example.pushvaadinapp;

import java.time.Instant;
import net.engio.mbassy.bus.MBassador;
import net.engio.mbassy.bus.common.DeadMessage;
import net.engio.mbassy.bus.config.BusConfiguration;
import net.engio.mbassy.bus.config.Feature;
import net.engio.mbassy.listener.Handler;

/**
 * A singleton to register objects (mostly user-interface components) interested
 * in being periodically notified with fresh data.
 *
 * Works in tandem with a DataProvider singleton which interacts with database
 * to look for fresh data.
 *
 * These two singletons, DataPublisher & DataProvider, could be combined into
 * one. But for testing, it might be handy to keep them separated.
 *
 * @author Basil Bourque
 */
public class DataPublisher
{

    // Statics
    private static final DataPublisher singleton = new DataPublisher();

    // Member vars.
    private final MBassador<DataEvent> eventBus;

    // Constructor. Private, for simple Singleton pattern.
    private DataPublisher ()
    {
        System.out.println( Instant.now().toString() + " Method DataPublisher::constructor running." );  // DEBUG logging.
        BusConfiguration busConfig = new BusConfiguration();
        busConfig.addFeature( Feature.SyncPubSub.Default() );
        busConfig.addFeature( Feature.AsynchronousHandlerInvocation.Default() );
        busConfig.addFeature( Feature.AsynchronousMessageDispatch.Default() );
        this.eventBus = new MBassador<>( busConfig );
        //this.eventBus = new MBassador<>( BusConfiguration.SyncAsync() );
        //this.eventBus.subscribe( this );
    }

    // Singleton accessor.
    public static DataPublisher instance ()
    {
        System.out.println( Instant.now().toString() + " Method DataPublisher::instance running." );   // DEBUG logging.
        return singleton;
    }

    public void register ( Object subscriber )
    {
        System.out.println( Instant.now().toString() + " Method DataPublisher::register running." );   // DEBUG logging.
        this.eventBus.subscribe( subscriber ); // The event bus is thread-safe. So hopefully we need no concurrency managament here.
    }

    public void deregister ( Object subscriber )
    {
        System.out.println( Instant.now().toString() + " Method DataPublisher::deregister running." );   // DEBUG logging.
        // Would be unnecessary to deregister if the event bus held weak references.
        // But it might be a good practice anyways for subscribers to deregister when appropriate.
        this.eventBus.unsubscribe( subscriber ); // The event bus is thread-safe. So hopefully we need no concurrency managament here.
    }

    public void publishIfReady ()
    {
        System.out.println( Instant.now().toString() + " Method DataPublisher::publishIfReady running." );   // DEBUG logging.

        // We expect this method to be called repeatedly by a ScheduledExecutorService.
        DataProvider dataProvider = DataProvider.instance();
        Boolean isFresh = dataProvider.checkForFreshData();
        if ( isFresh ) {
            DataEvent dataEvent = dataProvider.data();
            if ( dataEvent != null ) {
                System.out.println( Instant.now().toString() + " Method DataPublisher::publishIfReady…post running." );   // DEBUG logging.
                this.eventBus.publishAsync( dataEvent ); // Ideally this would be an asynchronous dispatching to bus subscribers.
            }
        }
    }

    @Handler
    public void deadEventHandler ( DeadMessage event )
    {
        // A dead event is an event posted but had no subscribers.
        // You may want to subscribe to DeadEvent as a debugging tool to see if your event is being dispatched successfully.
        System.out.println( Instant.now() + " DeadMessage on MBassador event bus : " + event );
    }

}