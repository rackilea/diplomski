/**
 * A log handler which creates a visible window for logging output.
 * 
 * <p>A WindowHandler is a standard log handler which may be utilized
 * in just the same was as any other log handler.</p>
 *
 * <p>In addition, a convenience static method is provided, WindowHandler.show(),
 * which will programmatically install a root handler and display a window,
 * allowing debugging output to be easily captured and viewed on screen.</p>
 * 
 * @author Brenden
 */
public class WindowHandler extends java.util.logging.Handler {

   // These static globals must be accessed on the EDT only!
   private static WindowHandler globalHandler;
   private static final ArrayList<WeakReference<WindowHandler>> windowList =
           new ArrayList<>();

   private JTextArea text;
   private JFrame logWindow;

   /**
    * Returns the window component (usually a JFrame) associated with this
    * WindowHandler.
    * 
    * @return The top-level window for this handler.
    */
   public Component getWindow() {
      return logWindow;
   }

   /**
    * Returns the JTextArea associated with the logging output captured by
    * this handler.
    * 
    * @return A JTextArea where logging is displayed. 
    */
   public JTextArea getTextArea() {
      return text;
   }

   /**
    * A list of ALL WindowHandler created so far in the system.
    * 
    * <p>This list is useful for getting a list of windows on screen, for
    * example, and then performing some operation on these windows.  For
    * example, hiding all windows, or closing them, or tiling them on screen
    * for easier viewing.</p>
    * 
    * @return An array list of all current window handlers. 
    */
   public static ArrayList<WindowHandler> getHandlers() {
      ArrayList<WindowHandler> retVal = new ArrayList<>();
      for( WeakReference<WindowHandler> wr : windowList ) {
         WindowHandler h = wr.get();
         if( h != null ) retVal.add( h );
      }
      return retVal;
   }

   /**
    * A convenience method for starting an instance of a WindowHandler.
    * 
    * <p>Call this method at the beginning of your program.  After calling
    * this method, all debugging output will be captured by the 
    * WindowHandler.  Note that individual loggers still have their respective
    * log levels.  WindowHandler is set to Level.ALL by default, but won't
    * receive output from loggers that have their own levels set too high
    * to capture output.</p>
    */
   public static synchronized void show() {
      utilEDTWait( () -> {
         if( globalHandler == null ) {
            Logger root = Logger.getLogger( "" );
            root.addHandler( globalHandler = new WindowHandler() );
         } else {
            globalHandler.getWindow().setVisible( true );
         }
      } );
   }

   /**
    * Creates a new WindowHandler.
    * 
    * <p>This method creates a new handler, sets its level to ALL, and creates
    * the necessary Swing components on the EDT, and displays those components
    * as well.  After creation, this handler may still be configured as normal
    * for any other logging handler.</p>
    */
   public WindowHandler() {
      utilEDTWait( () -> {
         setLevel( Level.ALL );
         JFrame frame = new JFrame( "DEBUG" );
         text = new JTextArea();
         text.setEditable( false );
         text.setPreferredSize( new Dimension( 300, 300 ) );
         JScrollPane scroll = new JScrollPane( text );
         frame.add( scroll );
         frame.setDefaultCloseOperation( JFrame.HIDE_ON_CLOSE );
         frame.pack();
         frame.setLocation( windowList.size()*20, windowList.size()*20 );
         frame.setVisible( true );
         logWindow = frame;
         windowList.add( new WeakReference<>( this ) );
      } );
   }

   @Override
   public void publish( LogRecord record ) {
      SwingUtilities.invokeLater( () -> {
         StringBuilder log = new StringBuilder( text.getText() );
         log.append( record.getMessage() );
         log.append( " -- " );
         log.append( record.getLoggerName() );
         log.append( " : " );
         log.append( record.getLevel() );
         log.append( "  //  " );
         log.append( new Date( record.getMillis() ) );
         log.append( "\n" );
         text.setText( log.toString() );
      } );
   }

   @Override
   public void flush() {
   }

   @Override
   public void close() throws SecurityException {
   }

   private static void utilEDTWait( Runnable r ) {
      if( SwingUtilities.isEventDispatchThread() ) {
         r.run();
      } else {
         try {
            SwingUtilities.invokeAndWait( r );
         } catch( InterruptedException ex ) {
            Thread.currentThread().interrupt();
            throw new RuntimeException( ex );
         } catch( InvocationTargetException ex ) {
            Logger.getLogger( WindowHandler.class.getName() ).log( Level.SEVERE, null, ex );
         }
      }
   }

}