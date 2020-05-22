webView = new WebView( );
    webView.setContextMenuEnabled( false );
    webView.addEventHandler( MouseEvent.MOUSE_CLICKED, this::onMouseClicked );
...
    private void onMouseClicked( MouseEvent event ) {
    WebEngine engine = webView.getEngine( );
    if( event.getButton( ) == MouseButton.SECONDARY ) {
        JSObject clientRect = ( JSObject )engine.executeScript( 
            "tinymce.activeEditor.getContentAreaContainer().getBoundingClientRect()" 
        );
        int x = ( Integer )clientRect.getMember( "left" );
        int y = ( Integer )clientRect.getMember( "top" );
        y = ( int )( event.getY( ) - y );
        x = ( int )( event.getX( ) - x );
        if( y >= 0 && x >= 0 ) {
            engine.executeScript( 
                "tinymce.activeEditor.fire('contextmenu', { bubbles: true, cancelable: true, view: window, buttons: 2, "
                        + "clientX: " + x + ", clientY: " + y + " }, true);" 
            );
        }
    }
}