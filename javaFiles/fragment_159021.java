package com.example.pushvaadinapp;

import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import java.time.Instant;
import net.engio.mbassy.listener.Handler;

@Push
@Theme ( "mytheme" )
@Widgetset ( "com.example.pushvaadinapp.MyAppWidgetset" )
public class DataUI extends UI
{

    // Member vars.
    DataLayout layout;

    @Override
    protected void init ( VaadinRequest request )
    {
        System.out.println( Instant.now().toString() + " Method DataUI::init running." );   // DEBUG logging.

        // Initialize window.
        this.getPage().setTitle( "Database Display" );
        // Content.
        this.layout = new DataLayout();
        this.setContent( this.layout );

        DataPublisher.instance().register( this ); // Sign-up for notification of fresh data delivery.
    }

    @Handler
    public void update ( DataEvent event )
    {
        System.out.println( Instant.now().toString() + " Method DataUI::update (@Subscribe) running." );   // DEBUG logging.

        // We expect to be given a DataEvent item.
        // In a real app, we might need to retrieve data (such as a Collection) from within this event object.
        this.access( () -> {
            this.layout.update( event ); // Crucial that go through the UI:access method when updating the user interface (widgets) from another thread.
        } );
    }

}