public class DynamicScrolledComposite {

  public static void main( String[] args ) {
    Display display = new Display();
    Shell shell = new Shell( display );
    shell.setLayout( new FillLayout() );
    ScrolledComposite scrolledComposite = new ScrolledComposite( shell, SWT.H_SCROLL | SWT.V_SCROLL );
    scrolledComposite.setExpandVertical( true );
    scrolledComposite.setExpandHorizontal( true );
    scrolledComposite.addListener( SWT.Resize, event -> updateMinSize( scrolledComposite ) );
    Composite composite = new Composite( scrolledComposite, SWT.NONE );
    composite.setLayout( new GridLayout( 1, false ) );
    createButton( composite );
    scrolledComposite.setContent( composite );
    shell.setSize( 600, 300 );
    shell.open();
    while( !shell.isDisposed() ) {
      if( !display.readAndDispatch() )
        display.sleep();
    }
    display.dispose();
  }

  private static void updateMinSize( ScrolledComposite scrolledComposite ) {
    Rectangle clientArea = scrolledComposite.getClientArea();
    clientArea.width -= scrolledComposite.getVerticalBar().getSize().x;
    Point minSize = scrolledComposite.getContent().computeSize( clientArea.width, SWT.DEFAULT );
    scrolledComposite.setMinSize( minSize );
  }

  private static void createButton( Composite parent ) {
    Button button = new Button( parent, SWT.PUSH );
    button.setText( "Add another button" );
    button.addListener( SWT.Selection, new Listener() {
      @Override
      public void handleEvent( Event event ) {
        createButton( parent );
        ScrolledComposite scrolledComposite = ( ScrolledComposite )button.getParent().getParent();
        button.getParent().requestLayout();
        updateMinSize( scrolledComposite );
      }
    } );
  }
}