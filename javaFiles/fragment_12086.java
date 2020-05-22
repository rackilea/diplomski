CommandButton button = new CommandButton();
    button.setId( "status-change" ); // must have, otherwise no action listeners called!
    button.setIcon( "ui-icon ui-icon-flag" );
    button.setProcess( "@this" );
    button.setUpdate( ":content-form:request-panel :filter-form" );

    ValueExpression valueExpression;

    // some action listener added...

    // programmatically add p:resetInput
    valueExpression = factory.createValueExpression( elContext, ":content-form:request-subpanel", String.class );
    button.addActionListener( new ResetInputActionListener( valueExpression ) );