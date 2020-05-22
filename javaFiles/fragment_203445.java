@Override
public void updateItem( String item, boolean empty )
{
    super.updateItem( item, empty );

    // With this, skin fails to calculate virtual flow's height
    // setWrapText( true );

    setText( null );

    if ( item != null )
    {
        // Ex-1: Manage the text width
        Text text = new Text( item );
        text.wrappingWidthProperty().bind( getListView().widthProperty().subtract( 20 ) );
        setGraphic( text );


        // Ex-2: Manage the pane width
        Label label = new Label( item );
        label.setWrapText( true );
        VBox pane = new VBox( label );
        pane.prefWidthProperty().bind( getListView().widthProperty().subtract( 20 ) );
        setGraphic( pane );
    }
    else
    {
        setGraphic( null );
    }
}