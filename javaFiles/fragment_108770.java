public class InputStreamReader
  implements Runnable
{
   protected InputStream in;
   protected List<ChangeListener> listeners;

   public InputStreamReader( InputStream in )
   {
     this.in = in;
     this.listeners = new ArrayList<ChangeListener>();
   }

   public void addChangeListener( ChangeListener l )
   {
     this.listeners.add( l );
   }

   public void run()
   {
     byte[] bytes = new byte[256]; //make this whatever you need
     in.read( bytes );

     //need some more checking here to make sure 256 bytes was read, etc.
     //Maybe write a subclass of ChangeEvent
     ChangeEvent evt = new ChangeEvent( bytes );
     for( ChangeListener l : listeners )
     {
       l.stateChanged( evt );
     }
   }
}