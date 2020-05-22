public static void main( String[] args ) {
    Display display = new Display();
    Shell shell = new Shell( display );
    shell.setLayout( new FillLayout() );
    final Table table = new Table( shell, SWT.VIRTUAL );
    table.setItemCount( 10000 );
    table.addListener( SWT.SetData, new Listener() {
        public void handleEvent( Event event ) {
            TableItem item = (TableItem)event.item;
            item.setText( "Item " + table.indexOf( item ) );
        }
    } );
    shell.setSize( 300, 500 );
    shell.open();
    while( !shell.isDisposed() ) {
        if( !display.readAndDispatch() ) {
            display.sleep();
        }
    }
    display.dispose();
}