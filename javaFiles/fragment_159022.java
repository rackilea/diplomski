/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.pushvaadinapp;

import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import java.time.Instant;

/**
 *
 * @author brainydeveloper
 */
public class DataLayout extends VerticalLayout
{

    TextField uuidField;
    TextField numericField;
    TextField updatedField;
    TextField whenCheckedField;

    // Constructor
    public DataLayout ()
    {
        System.out.println( Instant.now().toString() + " Method DataLayout::constructor running." );   // DEBUG logging.

        // Configure layout.
        this.setMargin( Boolean.TRUE );
        this.setSpacing( Boolean.TRUE );

        // Prepare widgets.
        this.uuidField = new TextField( "UUID : " );
        this.uuidField.setWidth( 22 , Unit.EM );
        this.uuidField.setReadOnly( true );

        this.numericField = new TextField( "Number : " );
        this.numericField.setWidth( 22 , Unit.EM );
        this.numericField.setReadOnly( true );

        this.updatedField = new TextField( "Updated : " );
        this.updatedField.setValue( "<Content will update automatically>" );
        this.updatedField.setWidth( 22 , Unit.EM );
        this.updatedField.setReadOnly( true );

        // Arrange widgets.
        this.addComponent( this.uuidField );
        this.addComponent( this.numericField );
        this.addComponent( this.updatedField );
    }

    public void update ( DataEvent dataHolder )
    {
        System.out.println( Instant.now().toString() + " Method DataLayout::update (via @Subscribe on UI) running." );   // DEBUG logging.

        // Stuff data values into fields. For simplicity in this example app, using String directly rather than Vaadin converters.
        this.uuidField.setReadOnly( false );
        this.uuidField.setValue( dataHolder.uuid.toString() );
        this.uuidField.setReadOnly( true );

        this.numericField.setReadOnly( false );
        this.numericField.setValue( dataHolder.number.toString() );
        this.numericField.setReadOnly( true );

        this.updatedField.setReadOnly( false );
        this.updatedField.setValue( dataHolder.updated.toString() );
        this.updatedField.setReadOnly( true );
    }

}