public class TableTransferHandlerDemo {

  public static void main( String[] args ) throws InvocationTargetException, InterruptedException {
    EventQueue.invokeAndWait( new Runnable() {
      public void run() {
        JFrame frame = new JFrame( "TestFrame" );

        JPanel contentPane = new JPanel( new BorderLayout(  ) );
        contentPane.add( createTable(), BorderLayout.CENTER );
        frame.getContentPane().add( contentPane );

        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.pack();
        frame.setVisible( true );
      }
    } );
  }

  private static CompositeStringValue createStringValue() {
    CompositeStringValue stringValue = new CompositeStringValue();
    stringValue.delegates.add( new AltitudeStringValue() );
    stringValue.delegates.add( new SpeedStringValue() );
    return stringValue;
  }

  public static JXTable createTable(){
    final JXTable table = new JXTable(  );
    table.setSelectionMode( ListSelectionModel.MULTIPLE_INTERVAL_SELECTION );
    table.setModel( createTableModel() );
    CompositeStringValue stringValue = createStringValue();
    table.setDefaultRenderer( Object.class, new DefaultTableRenderer( stringValue ) );
    table.setTransferHandler( new TableTransferHandler( table, stringValue ) );
    //make sure ctrl-c triggers a copy
    InputMap inputMap = table.getInputMap( JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT );
    inputMap.put( KeyStroke.getKeyStroke( KeyEvent.VK_C, InputEvent.CTRL_MASK ), "copyAction" );
    table.getActionMap().put( "copyAction", new AbstractAction() {
      public void actionPerformed( ActionEvent e ) {
        ActionEvent event = new ActionEvent( table, e.getID(), e.getActionCommand(), e.getWhen(), e.getModifiers() );
        TransferHandler.getCopyAction().actionPerformed( event );
      }
    } );
    return table;
  }

  public static class Speed{
    public double speed;
    public String unit = "km/h";
    public Speed( double speed ){ this.speed = speed;}
  }
  public static class Altitude{
    public double altitude;
    public String unit = "m";
    public Altitude( double altitude ){ this.altitude = altitude; }
  }
  public static class SpeedStringValue implements StringValue{
    public String getString( Object o ) {
      if ( o instanceof Speed ){
        return ( ( Speed ) o ).speed + ( ( Speed ) o ).unit;
      }
      return null;
    }
  }
  public static class AltitudeStringValue implements StringValue{
    public String getString( Object o ) {
      if ( o instanceof Altitude ){
        return ( ( Altitude ) o ).altitude + ( ( Altitude ) o ).unit;
      }
      return null;
    }
  }
  public static class CompositeStringValue implements StringValue{
    public List<StringValue> delegates = new ArrayList<StringValue>(  );
    public String getString( Object o ) {
      for ( StringValue stringValue : delegates ) {
        String string = stringValue.getString( o );
        if ( string != null ) return string;
      }
      return o != null ? o.toString() : "null";
    }
  }
  public static TableModel createTableModel(){
    return new DefaultTableModel(
        new Object[][]{ new Object[]{ new Speed( 10 ), new Altitude( 100 )},
            new Object[]{ new Speed( 20 ), new Altitude( 200 ) }},
        new Object[]{"Speed", "Altitude"} );
  }
  public static class TableTransferHandler extends TransferHandler{
    private JXTable table;
    private StringValue stringValue;

    public TableTransferHandler( JXTable aTable, StringValue aStringValue ) {
      table = aTable;
      stringValue = aStringValue;
    }
    @Override
    public void exportToClipboard( JComponent aComponent, Clipboard aClipboard, int aAction ) throws IllegalStateException {
      JTable table = createTable();
      table.getTransferHandler().exportToClipboard( table, aClipboard, aAction );
    }
    @Override
    public void exportAsDrag( JComponent aComponent, InputEvent aEvent, int aAction ) {
      JTable table = createTable();
      table.getTransferHandler().exportAsDrag( table, aEvent, aAction );
    }
    @Override
    protected Transferable createTransferable( JComponent c ) {
      //this transfer handler should not create any transferables
      return null;
    }
    /**
     * Create a table, representing the JXTable containing only Strings
     */
    private JTable createTable() {
      JTable table = new JTable( new StringTableModel( this.table, stringValue ) );
      table.setSelectionModel( this.table.getSelectionModel() );//make sure the selection is synced
      return table;
    }
  }

  private static class StringTableModel extends AbstractTableModel {
    private JXTable delegateTable;
    private StringValue stringValue;

    private StringTableModel( JXTable aTable, StringValue aStringValue ) {
      delegateTable = aTable;
      stringValue = aStringValue;
    }

    public int getRowCount() {
      return delegateTable.getModel().getRowCount();
    }

    public int getColumnCount() {
      return delegateTable.getModel().getColumnCount();
    }

    public Object getValueAt( int aRowIndex, int aColumnIndex ) {
      return stringValue.getString( delegateTable.getValueAt( aRowIndex, aColumnIndex ) );
    }
  }
}